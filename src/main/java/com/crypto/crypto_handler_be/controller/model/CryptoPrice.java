package com.crypto.crypto_handler_be.controller.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
public class CryptoPrice implements Serializable {

    @Serial
    private static final long serialVersionUID = 7922040852307590395L;

    private String name;
    private double price;
    private String currency;

    public CryptoPrice(String name, double price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

}
