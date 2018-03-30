package com.myretail.myretailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.myretail.myretailservice"})
@PropertySources({
		@PropertySource("classpath:application.yml")
})
public class MyretailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyretailServiceApplication.class, args);
	}
}
