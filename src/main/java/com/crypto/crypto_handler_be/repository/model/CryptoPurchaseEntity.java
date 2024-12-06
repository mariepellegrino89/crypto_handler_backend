package com.crypto.crypto_handler_be.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Setter
@Getter
@Document(collection = "CRIPTO_HISTORY")
public class CryptoPurchaseEntity {

    @Id
    private String id;
    @Field("crypto_currency")
    private String cryptoCurrency;
    @Field("fiat_currency_buy_value")
    private List<FiatCurrencyBuyValue> fiatCurrencyBuyValue;
    @Field("quantity_bought")
    private double quantityBought;
    @Field("date")
    private String date;

}
