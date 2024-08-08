package com.rkg.learning.camunda8.handler;

import com.rkg.learning.camunda8.service.CreditCardService;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditCardServiceHandler implements JobHandler {

    @Autowired
    private CreditCardService creditCardService;

    @Override
    public void handle(JobClient client, ActivatedJob job) {
        creditCardService.chargeCreditCard();
        client.newCompleteCommand(job.getKey()).send().join();
        log.info("Payment process task completed");
    }
}