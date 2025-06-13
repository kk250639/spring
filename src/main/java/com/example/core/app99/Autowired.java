package com.example.core.app99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Autowired {
    public static void main(String[] args) {
        var context = SpringApplication.run(Autowired.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        bean.go();

    }
}
@Component
class Controller1{
    @org.springframework.beans.factory.annotation.Autowired
    Service1 service;
    public void go(){
        service.action1();
    }
}

@Component
class Service1{
    public void action1(){
        System.out.println("action1");
    }
}