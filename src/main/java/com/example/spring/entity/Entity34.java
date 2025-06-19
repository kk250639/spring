package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table34")
@Getter
@Setter
@ToString
public class Entity34 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate birthDate;

    private String info;
}

//package com.example.spring.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "my_table34", schema = "jpa")
//public class Entity34 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @Column(name = "name", length = 30)
//    private String name;
//
//    @Column(name = "brith_date")
//    private LocalDate brithDate;
//
//    @Column(name = "info", length = 30)
//    private String info;
//
//}