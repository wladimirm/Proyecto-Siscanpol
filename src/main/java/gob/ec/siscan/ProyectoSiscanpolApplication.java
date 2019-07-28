package gob.ec.siscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) // Not: /error
public class ProyectoSiscanpolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSiscanpolApplication.class, args);
	}

}
