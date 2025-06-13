package com.example.core.app99;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class setAutowired {
    public static void main(String[] args) {
        var context = SpringApplication.run(setAutowired.class, args);
        Bean3 bean = context.getBean(Bean3.class);
        bean.go();
    }
}

@Component
class Bean3 {
    Bean4 b4;

    @Autowired
    public void setB4(Bean4 b4) {
        this.b4 = b4;
    }

    public void go() {
        b4.action();
    }


}

@Component
class Bean4 {

    public void action() {
        System.out.println("Bean4.action");
    }
}