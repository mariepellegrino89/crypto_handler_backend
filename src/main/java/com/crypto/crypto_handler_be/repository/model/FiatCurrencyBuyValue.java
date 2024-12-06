package com.crypto.crypto_handler_be.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FiatCurrencyBuyValue {

    @Field("currency")
    private String currency;
    @Field("value")
    private double value;

}
