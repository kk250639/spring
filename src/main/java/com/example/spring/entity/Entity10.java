package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "my_table10", schema = "jpa")
@ToString
public class Entity10 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 300)
    private String name;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}