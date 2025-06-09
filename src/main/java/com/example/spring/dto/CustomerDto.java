package com.example.spring.dto;

import lombok.Data;
// main13/sub12
@Data
public class CustomerDto {
    private Integer id;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String contact;
}
