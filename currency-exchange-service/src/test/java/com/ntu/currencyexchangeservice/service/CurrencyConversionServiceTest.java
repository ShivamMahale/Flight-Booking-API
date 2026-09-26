package com.ntu.currencyexchangeservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.math.BigDecimal;

import com.ntu.currencyexchangeservice.model.CurrencyConversionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

class CurrencyConversionServiceTest {

    private RestTemplate restTemplate;
    private MockRestServiceServer provider;
    private CurrencyConversionService service;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        provider = MockRestServiceServer.bindTo(restTemplate).build();
        service = new CurrencyConversionService(restTemplate, "https://rates.example");
    }

    @Test
    void convertsAmountUsingProviderRateAndTargetCurrencyPrecision() {
        provider.expect(requestTo("https://rates.example/latest?from=USD&to=EUR"))
                .andRespond(withSuccess("{\"rates\":{\"EUR\":0.92}}", MediaType.APPLICATION_JSON));

        BigDecimal converted = service.convert(request("USD", "EUR", "100"));

        assertThat(converted).isEqualByComparingTo("92.00");
        provider.verify();
    }

    @Test
    void returnsSameCurrencyAmountWithoutCallingProvider() {
        BigDecimal converted = service.convert(request("USD", "USD", "12.345"));

        assertThat(converted).isEqualByComparingTo("12.34");
        provider.verify();
    }

    @Test
    void rejectsInvalidCurrencyCode() {
        assertThatThrownBy(() -> service.convert(request("USX", "EUR", "1")))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("Invalid sourceCurrency");
    }

    private CurrencyConversionRequest request(String source, String target, String amount) {
        CurrencyConversionRequest request = new CurrencyConversionRequest();
        request.setSourceCurrency(source);
        request.setTargetCurrency(target);
        request.setAmount(new BigDecimal(amount));
        return request;
    }
}