package com.crypto.crypto_handler_be.controller;

import com.crypto.crypto_handler_be.controller.model.CryptoPrice;
import com.crypto.crypto_handler_be.service.CryptoHistoryService;
import com.crypto.crypto_handler_be.service.CryptoPriceService;
import com.crypto.crypto_handler_be.service.model.CryptoBuyHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CryptoHandlerController {

    @Autowired
    private CryptoHistoryService cryptoHistoryService;

    @Autowired
    private CryptoPriceService priceService;


    @GetMapping(path = "/price")
    public ResponseEntity<List<CryptoPrice>> getCryptoPrices(){

        List<CryptoPrice> cryptoPrices = priceService.retrieveCryptoPrice();
        return new ResponseEntity<>(cryptoPrices, HttpStatus.OK);

    }

    @GetMapping(path = "/history")
    public ResponseEntity<List<CryptoBuyHistoryDTO>> getCryptoHistory(){

        List<CryptoBuyHistoryDTO> cryptoBuyHistoryDTOS = cryptoHistoryService.getCryptoHistory();
        return new ResponseEntity<>(cryptoBuyHistoryDTOS, HttpStatus.OK);

    }
}
