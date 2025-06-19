package com.example.spring.dto;

import com.example.spring.entity.Entity35;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Entity35}
 */
@Value
public class Entity35Dto implements Serializable {
    Integer id;
    String lectureTitle;
    String info;
    String place;
}