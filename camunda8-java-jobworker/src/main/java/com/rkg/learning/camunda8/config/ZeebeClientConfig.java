package com.rkg.learning.camunda8.config;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ZeebeClientConfig {

    private static final String ZEEBE_ADDRESS = "ZEEBE_ADDRESS";
    private static final String ZEEBE_CLIENT_ID = "ZEEBE_CLIENT_ID";
    private static final String ZEEBE_CLIENT_SECRET = "ZEEBE_CLIENT_SECRET";
    private static final String ZEEBE_AUTHORIZATION_SERVER_URL = "ZEEBE_AUTHORIZATION_SERVER_URL";
    private static final String ZEEBE_TOKEN_AUDIENCE = "zeebe.camunda.io";

    @Bean
    public ZeebeClient zeebeClient() {
        final OAuthCredentialsProvider credentialsProvider = new OAuthCredentialsProviderBuilder()
                .authorizationServerUrl(ZEEBE_AUTHORIZATION_SERVER_URL)
                .audience(ZEEBE_TOKEN_AUDIENCE)
                .clientId(ZEEBE_CLIENT_ID)
                .clientSecret(ZEEBE_CLIENT_SECRET).build();

        ZeebeClient zeebeClient = ZeebeClient.newClientBuilder()
                .gatewayAddress(ZEEBE_ADDRESS)
                .credentialsProvider(credentialsProvider)
                .build();
        log.info("Successfully initialized zeebe client");
        return zeebeClient;
    }
}
