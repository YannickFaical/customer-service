package com.gestion.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
