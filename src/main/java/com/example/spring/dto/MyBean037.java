package com.example.spring.dto;


import lombok.ToString;


@ToString
public class MyBean037 {
    private String name;
    private String address;
    private String pw;
    // field : name, address, pw
    // property : name, address, password
    // property 이름은 gette, setter에 의해 결정

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
