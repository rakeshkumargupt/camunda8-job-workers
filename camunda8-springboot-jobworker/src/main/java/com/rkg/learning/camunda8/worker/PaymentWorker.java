package com.rkg.learning.camunda8.worker;

import com.rkg.learning.camunda8.service.CreditCardService;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentWorker {

    private final CreditCardService creditCardService;

    @JobWorker(type = "completePayment")
    public void processPayment(final JobClient client, final ActivatedJob job) {
        creditCardService.chargeCreditCard();
        client.newCompleteCommand(job.getKey()).send().join();
        log.info("Payment process task completed");
    }
}
