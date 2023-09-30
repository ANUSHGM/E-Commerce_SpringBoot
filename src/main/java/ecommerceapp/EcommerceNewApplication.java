package ecommerceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ecommerceapp")
public class EcommerceNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceNewApplication.class, args);
	}

}
