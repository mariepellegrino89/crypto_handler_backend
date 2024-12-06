package com.crypto.crypto_handler_be.service.model;

import com.crypto.crypto_handler_be.repository.model.FiatCurrencyBuyValue;
import lombok.Data;

import java.util.List;

@Data
public class CryptoBuyHistoryDTO {

    private String cryptoCurrency;
    private List<FiatCurrencyBuyValue> fiatCurrencyBuyValue;
    private double quantityBought;
    private String date;

}
