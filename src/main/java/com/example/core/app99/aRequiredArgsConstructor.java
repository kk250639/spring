package com.example.core.app99;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class aRequiredArgsConstructor {
    public static void main(String[] args) {
        var context = SpringApplication.run(aRequiredArgsConstructor.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        bean.a();
    }
}
@Component
@RequiredArgsConstructor
class Bean1 {

    final Bean2 b;
    public void a() {
        b.action();
    }
}
@Component
class Bean2 {

    public void action() {
        System.out.println("Bean2.b");
    }
}