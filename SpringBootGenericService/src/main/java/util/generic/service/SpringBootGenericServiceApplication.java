package util.generic.service;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootGenericServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGenericServiceApplication.class, args);
	}
}
