package com.gestion.customerservice.controllers;

import com.gestion.customerservice.entities.Customer;
import com.gestion.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        return  customerRepository.findAll();
    }

    @GetMapping("/customers/email/{email}")
    public ResponseEntity<Customer> findCustomerByEmail(@PathVariable(required = true) String email) {
        System.out.println("Email reçu : " + email);
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            System.out.println("Email inexistant ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(customer);
    }



    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
       return customerRepository.save(customer);
    }


    @DeleteMapping("/customers/id/{id}")
    public void deleteCustomer(@PathVariable Long id ){
      Optional<Customer> existingCustomer= customerRepository.findById(id);

        if(existingCustomer.isPresent()){
            customerRepository.deleteById(id);
        }

    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(updatedCustomer.getName());
                    existingCustomer.setEmail(updatedCustomer.getEmail());
                    Customer savedCustomer = customerRepository.save(existingCustomer);
                    return ResponseEntity.ok(savedCustomer);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
