package com.example.spring.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.spring.entity.Entity37}
 */
@Setter
@NoArgsConstructor
public class Entity37Dto implements Serializable {
    String email;
    String info;
    LocalDateTime insertedAt;
}