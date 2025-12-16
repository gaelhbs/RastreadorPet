package com.senai.rastreadorpet;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class RastreadorPetApplication {


    public static void main(String[] args) {
        SpringApplication.run(RastreadorPetApplication.class, args);
    }
}
