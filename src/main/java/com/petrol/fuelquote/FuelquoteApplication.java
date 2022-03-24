package com.petrol.fuelquote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class FuelquoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelquoteApplication.class, args);
    }

}
