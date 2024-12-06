package com.crypto.crypto_handler_be.service;

import com.crypto.crypto_handler_be.controller.model.CryptoPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CryptoPriceClient {

    private static final String COINGECKO_URL = "https://api.coingecko.com/api/v3/simple/price";

    @Autowired
    private RestTemplate restTemplate;


    public List<CryptoPrice> getPrices(List<String> ids) {
        // Creazione URL dinamico
        String url = UriComponentsBuilder.fromUriString(COINGECKO_URL)
                .queryParam("ids", String.join(",", ids))
                .queryParam("vs_currencies", "usd")
                .toUriString();

        // Chiamata all'API
        Map<String, Map<String, Integer>> response = restTemplate.getForObject(url, Map.class);

        // Mappare la risposta su una lista di CryptoPrice
        List<CryptoPrice> cryptoPrices = new ArrayList<>();
        if(response!=null) {
            for (Map.Entry<String, Map<String, Integer>> entry : response.entrySet()) {
                String name = entry.getKey();
                double price = parsePrice(entry.getValue().get("usd"));
                cryptoPrices.add(new CryptoPrice(name, price, "USD"));
            }
        }
        return cryptoPrices;
    }

    private double parsePrice(Object price) {
        if (price instanceof Integer) {
            return ((Integer) price).doubleValue();
        } else if (price instanceof Double) {
            return (Double) price;
        } else {
            throw new IllegalArgumentException("Price is neither Integer nor Double: " + price);
        }
    }
}
