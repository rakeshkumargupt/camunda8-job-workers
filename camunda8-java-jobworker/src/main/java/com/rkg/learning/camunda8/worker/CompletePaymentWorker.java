package com.rkg.learning.camunda8.worker;

import com.rkg.learning.camunda8.handler.CreditCardServiceHandler;
import io.camunda.zeebe.client.ZeebeClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class CompletePaymentWorker {

    private final ZeebeClient zeebeClient;
    private final CreditCardServiceHandler creditCardServiceHandler;

    @PostConstruct
    public void checkPaymentJob() throws InterruptedException {
        System.out.println("Connected to: " + zeebeClient.newTopologyRequest().send().join());
        zeebeClient.newWorker()
                .jobType("completePayment")
                .handler(creditCardServiceHandler)
                .timeout(Duration.ofSeconds(10).toMillis())
                .open();
        Thread.sleep(10000);
    }
}
