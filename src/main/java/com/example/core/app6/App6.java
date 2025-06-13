package com.example.core.app6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App6 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App6.class, args);
        comp1 bean = context.getBean(comp1.class);
        bean.some();    // NullPointerException
    }
}
@Component
class comp1 {
    comp2 c2;

    // seter 사용한 Dependency Injection (DI)
    @Autowired
    public void setC2(comp2 c2) {
        this.c2 = c2;
    }

    public void some() {
        c2.crud();
    }
}

@Component
class comp2 {
    public void crud() {
        System.out.println("comp2.crud");
    }

}