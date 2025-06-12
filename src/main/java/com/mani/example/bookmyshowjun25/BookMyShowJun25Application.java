package com.mani.example.bookmyshowjun25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowJun25Application {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowJun25Application.class, args);
    }

}
