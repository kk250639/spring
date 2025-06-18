package com.example.spring.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="my_table25")
public class Entity25 {

    @EmbeddedId
    private Entity25Id id;
    private Integer age;
    private Integer phone;

}
