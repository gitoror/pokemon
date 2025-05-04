package com.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        for (var b : ctx.getBeanDefinitionNames()) {
            System.out.println(b);

        }
    }
}
