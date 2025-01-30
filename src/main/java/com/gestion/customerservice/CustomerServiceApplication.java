package com.gestion.customerservice;

import com.gestion.customerservice.entities.Customer;
import com.gestion.customerservice.repositories.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner save(CustomerRepository customerRepository){
        return args ->{


for(int i =0;i<10;i++){
    Faker faker = new Faker();
            Customer customer=Customer.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .build();
            customerRepository.save(customer);
}

            // Affichage pour vérifier si l'enregistrement est bien effectué
            customerRepository.findAll().forEach(System.out::println);
        };

    }
}
