package com.example.spring.dto;

import com.example.spring.entity.Entity36;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Entity36}
 */
@Data
public class Entity36Dto implements Serializable {
    LocalDate registeredAt;
    String studentName;
}