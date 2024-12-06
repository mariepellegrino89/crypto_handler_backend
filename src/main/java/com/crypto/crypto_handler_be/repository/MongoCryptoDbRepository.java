package com.crypto.crypto_handler_be.repository;

import com.crypto.crypto_handler_be.repository.model.CryptoPurchaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoCryptoDbRepository extends MongoRepository<CryptoPurchaseEntity, String> {


    List<CryptoPurchaseEntity> findCryptoPurchaseEntitiesBycryptoCurrency(String cryptoCurrency);

}
