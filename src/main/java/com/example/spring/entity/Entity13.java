package com.example.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="my_table13")
@Getter
@Setter
@ToString
public class Entity13 {
    @Id
    Integer id;
    String name;
    String phone;
    Integer age;
}
