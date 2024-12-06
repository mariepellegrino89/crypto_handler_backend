package com.crypto.crypto_handler_be.service;

import com.crypto.crypto_handler_be.controller.model.CryptoPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CryptoPriceService {


    @Autowired
    private CryptoPriceClient cryptoPriceClient;
    private final List<String> ids = List.of("bitcoin", "ethereum");

    public List<CryptoPrice> retrieveCryptoPrice() {
        return cryptoPriceClient.getPrices(ids);
    }
}
