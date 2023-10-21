package br.com.cardoso.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

import java.util.UUID;

public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("correlation_id", MDC.get("correlationId")).header("flow_id", UUID.randomUUID().toString());
    }
}
