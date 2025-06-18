package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity26Id implements Serializable {
    private static final long serialVersionUID = 8889910388917052373L;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity26Id entity = (Entity26Id) o;
        return Objects.equals(this.phone, entity.phone) &&
               Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name);
    }

}