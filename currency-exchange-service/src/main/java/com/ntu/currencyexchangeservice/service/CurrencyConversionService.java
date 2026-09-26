package com.ntu.currencyexchangeservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

import com.ntu.currencyexchangeservice.model.CurrencyConversionRequest;
import com.ntu.currencyexchangeservice.model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CurrencyConversionService {

    private final RestTemplate restTemplate;
    private final String providerBaseUrl;

    public CurrencyConversionService(
            RestTemplate restTemplate,
            @Value("${exchange.provider.base-url}") String providerBaseUrl) {
        this.restTemplate = restTemplate;
        this.providerBaseUrl = providerBaseUrl;
    }

    public BigDecimal convert(CurrencyConversionRequest request) {
        Currency source = parseCurrency(request.getSourceCurrency(), "sourceCurrency");
        Currency target = parseCurrency(request.getTargetCurrency(), "targetCurrency");
        BigDecimal amount = request.getAmount();

        if (source.equals(target)) {
            return roundForCurrency(amount, target);
        }

        URI ratesUri = UriComponentsBuilder.fromUriString(providerBaseUrl)
                .path("/latest")
                .queryParam("from", source.getCurrencyCode())
                .queryParam("to", target.getCurrencyCode())
                .build()
                .encode()
                .toUri();

        try {
            ExchangeRateResponse response = restTemplate.getForObject(ratesUri, ExchangeRateResponse.class);
            Map<String, BigDecimal> rates = response == null ? null : response.getRates();
            BigDecimal rate = rates == null ? null : rates.get(target.getCurrencyCode());
            if (rate == null || rate.signum() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Exchange rate was not returned by the provider.");
            }
            return roundForCurrency(amount.multiply(rate), target);
        } catch (RestClientException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Exchange rate provider is unavailable.", exception);
        }
    }

    private Currency parseCurrency(String code, String fieldName) {
        try {
            return Currency.getInstance(code.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + fieldName + " ISO 4217 code.");
        }
    }

    private BigDecimal roundForCurrency(BigDecimal amount, Currency currency) {
        int fractionDigits = currency.getDefaultFractionDigits();
        if (fractionDigits < 0) {
            fractionDigits = 2;
        }
        return amount.setScale(fractionDigits, RoundingMode.HALF_EVEN);
    }
}