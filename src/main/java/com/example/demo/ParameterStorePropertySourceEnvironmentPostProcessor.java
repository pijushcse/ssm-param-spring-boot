package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import software.amazon.awssdk.services.ssm.SsmClient;

@Configuration
public class ParameterStorePropertySourceEnvironmentPostProcessor implements EnvironmentPostProcessor {
    
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, 
                                       SpringApplication application) {
        environment.getPropertySources().addFirst(
            new ParameterStorePropertySource("AWSParameterStorePropertySource",
                                            SsmClient.builder()
                .region(software.amazon.awssdk.regions.Region.US_EAST_1)
                .build() ));
    }
}