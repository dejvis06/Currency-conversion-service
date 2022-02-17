package com.example.controller;

import com.example.entity.CurrencyConversion;
import com.example.entity.currency_exchange.CurrencyExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "currency-conversion")
public class CurrencyConversionController {

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        ResponseEntity<CurrencyExchange> currencyExchangeResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR", CurrencyExchange.class);
        CurrencyExchange currencyExchange = currencyExchangeResponseEntity.getBody();

        CurrencyConversion currencyConversion = CurrencyConversion.builder().from(currencyExchange.getFrom()).to(currencyExchange.getTo()).quantity(quantity).build();
        return new ResponseEntity<>(currencyConversion, HttpStatus.OK);
    }
}
