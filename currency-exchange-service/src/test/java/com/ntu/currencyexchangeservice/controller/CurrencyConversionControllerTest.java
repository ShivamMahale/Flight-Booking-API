package com.ntu.currencyexchangeservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.ntu.currencyexchangeservice.service.CurrencyConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(CurrencyConversionController.class)
class CurrencyConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyConversionService conversionService;

    @Test
    void returnsNumericConversionForClientContract() throws Exception {
        when(conversionService.convert(org.mockito.ArgumentMatchers.any()))
                .thenReturn(new BigDecimal("92.00"));

        mockMvc.perform(post("/api/currency-exchange/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sourceCurrency\":\"USD\",\"targetCurrency\":\"EUR\",\"amount\":100}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("92.00"));
    }

    @Test
    void rejectsNonPositiveAmount() throws Exception {
        mockMvc.perform(post("/api/currency-exchange/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sourceCurrency\":\"USD\",\"targetCurrency\":\"EUR\",\"amount\":0}"))
                .andExpect(status().isBadRequest());
    }
}