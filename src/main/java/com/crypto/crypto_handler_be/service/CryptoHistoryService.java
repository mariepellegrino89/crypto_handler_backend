package com.crypto.crypto_handler_be.service;

import com.crypto.crypto_handler_be.repository.MongoCryptoDbRepository;
import com.crypto.crypto_handler_be.repository.model.CryptoPurchaseEntity;
import com.crypto.crypto_handler_be.service.model.CryptoBuyHistoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CryptoHistoryService {

    @Autowired
    MongoCryptoDbRepository mongoCryptoDbRepository;

    public List<CryptoBuyHistoryDTO> getCryptoHistory() {
        List<CryptoBuyHistoryDTO> response = new ArrayList<>();

        List<CryptoPurchaseEntity> entities = mongoCryptoDbRepository.findCryptoPurchaseEntitiesBycryptoCurrency("BITCOIN");
        entities.forEach(e -> {
                    CryptoBuyHistoryDTO cryptoBuyHistoryDTO = new CryptoBuyHistoryDTO();
                    BeanUtils.copyProperties(e, cryptoBuyHistoryDTO);
                    response.add(cryptoBuyHistoryDTO);
                }
        );
        return response;
    }


}
