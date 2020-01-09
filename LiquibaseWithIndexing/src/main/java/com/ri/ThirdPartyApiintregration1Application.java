package com.ri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class ThirdPartyApiintregration1Application {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApiintregration1Application.class, args);
	}

}
