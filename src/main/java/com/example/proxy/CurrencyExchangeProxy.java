package com.example.proxy;

import com.example.model.rest.currency_exchange.CurrencyExchangeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ResponseEntity<CurrencyExchangeModel> retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
