package br.com.cardoso.configuration;

import br.com.cardoso.interceptor.FeignInterceptor;
import feign.micrometer.FeignObservationConvention;
import feign.micrometer.MicrometerObservationCapability;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorConfiguration {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return new FeignInterceptor();
    }

    @Bean
    public MicrometerObservationCapability micrometerObservationCapability(ObservationRegistry registry) {
        FeignObservationConvention feignObservationConvention = new CustomFeignObservationConvention();
        return new MicrometerObservationCapability(registry, feignObservationConvention);
    }
}
