package com.example.spring.dto;

import com.example.spring.entity.Entity41;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Entity41}
 */
@Value
public class Entity41Dto implements Serializable {
    LocalDate orderDate;
    String productName;
    Integer productPrice;
    String productCategoryName;
    Integer quantity;
}