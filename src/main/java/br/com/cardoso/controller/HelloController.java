package br.com.cardoso.controller;

import br.com.cardoso.service.HelloClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class HelloController {

    Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private final HelloClient helloClient;

    public HelloController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @GetMapping("/feign")
    public String feign() {
        MDC.put("correlationId", UUID.randomUUID().toString());
        return helloClient.getHelloWorld();
    }

    @GetMapping("/hello")
    public String hello(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            LOGGER.info(String.format("Header '%s' = %s", key, value));
        });
        return "Hello World";
    }
}
