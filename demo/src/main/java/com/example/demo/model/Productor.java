package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productores") // Assuming a table named 'productores'
public class Productor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // You might want to add other fields specific to a Producer
    // private String description;
    // private String contactInfo;

    public Productor() {
    }

    public Productor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add getters and setters for other fields if you add them
}
