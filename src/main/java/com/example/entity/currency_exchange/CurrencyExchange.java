package com.example.entity.currency_exchange;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyExchange {

    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
