package com.gestion.customerservice;

import com.gestion.customerservice.entities.Customer;
import com.gestion.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner save(CustomerRepository customerRepository){
//        return args ->{
//            Customer customer=Customer.builder()
//                    .name("yannick")
//                    .email("ycompaore48@gmail.com")
//                    .build();
//            customerRepository.save(customer);
//
//            // Affichage pour vérifier si l'enregistrement est bien effectué
//            customerRepository.findAll().forEach(System.out::println);
//        };
//
//    }
}
