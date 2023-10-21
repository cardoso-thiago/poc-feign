package br.com.cardoso.configuration;

import feign.micrometer.DefaultFeignObservationConvention;

public class CustomFeignObservationConvention extends DefaultFeignObservationConvention {

    @Override
    public String getName() {
        return "feign.http.client.requests";
    }
}
