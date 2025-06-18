package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "my_table26", schema = "jpa")
public class Entity26 {
    @EmbeddedId
    private Entity26Id id;

    @Column(name = "address")
    private Integer address;

    @Column(name = "age")
    private Integer age;

}