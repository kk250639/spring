package com.example.spring.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_table26")
public class Entity2626 {
    @EmbeddedId
    private Entity2626Id id;
    private String country;
    private String state;
    private String phone;

}
