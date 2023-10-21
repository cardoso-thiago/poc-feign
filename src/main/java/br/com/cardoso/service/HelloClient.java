package br.com.cardoso.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "HELLO-SERVICE", url = "http://localhost:8080")
public interface HelloClient {

    @GetMapping(value = "/hello")
    String getHelloWorld();
}
