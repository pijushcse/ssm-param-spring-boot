package com.example.demo;

import org.springframework.core.env.PropertySource;

import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;

public class ParameterStorePropertySource extends PropertySource<SsmClient> {

    public ParameterStorePropertySource(String name, SsmClient source) {
        super(name, source);
    }

    // AKIAZIDLCG3GXDGLKDPA
    // LbPtZBZr+vMffF4XqrurJXpgP4u8nO7q/q8cc5al

    @Override
    public String getProperty(String parameter) {
        if (parameter.startsWith("/lca")) {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(parameter)
                    .build();
            GetParameterResponse parameterResponse = source.getParameter(parameterRequest);
            return parameterResponse.parameter().value();
        }

        return null;
    }
}
