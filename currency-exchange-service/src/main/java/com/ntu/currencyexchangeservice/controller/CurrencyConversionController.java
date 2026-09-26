package com.ntu.currencyexchangeservice.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import com.ntu.currencyexchangeservice.model.CurrencyConversionRequest;
import com.ntu.currencyexchangeservice.service.CurrencyConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyConversionController {

    private final CurrencyConversionService conversionService;

    public CurrencyConversionController(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal convert(@Valid @RequestBody CurrencyConversionRequest request) {
        return conversionService.convert(request);
    }
}