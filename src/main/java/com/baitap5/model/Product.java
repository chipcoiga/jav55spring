package com.baitap5.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters & Setters
}
