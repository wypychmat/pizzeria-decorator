package com.wypychmat.pizzeria;

import com.wypychmat.pizzeria.api.PricingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PricingConfig.class)
public class PizzeriaApp {

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApp.class, args);
    }

}
