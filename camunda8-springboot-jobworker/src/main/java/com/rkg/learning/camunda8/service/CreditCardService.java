package com.rkg.learning.camunda8.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditCardService {

    public void chargeCreditCard() {
        log.info("Charging Credit Card");
    }
}