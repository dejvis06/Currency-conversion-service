package com.example.model.rest.currency_exchange;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyExchangeModel {

    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
