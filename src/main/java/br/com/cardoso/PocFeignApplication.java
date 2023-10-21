package br.com.cardoso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PocFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocFeignApplication.class, args);
	}

}
