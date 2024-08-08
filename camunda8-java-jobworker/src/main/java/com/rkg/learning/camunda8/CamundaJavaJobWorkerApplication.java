package com.rkg.learning.camunda8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CamundaJavaJobWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaJavaJobWorkerApplication.class, args);
    }

}
