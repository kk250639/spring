package com.example.core.app10;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App10 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App10.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        bean.action();
        Controller2 bean1 = context.getBean(Controller2.class);
        bean1.go();
    }
}

@Component
// fianl 필드를 파라미터는 받는 생성자 만들어 줌
@RequiredArgsConstructor
class Controller2 {
    final Service2 service2;

    public void go() {
        service2.action();
    }

}

@Component
class Service2 {
    public void action() {
        System.out.println("Service2.action");
    }

}

@Component
class Controller1 {
    final Service1 svc;

    public Controller1(Service1 svc) {
        this.svc = svc;
    }

    public void action() {
        svc.method();
    }
}

@Component
class Service1 {
    public void method() {
        System.out.println("Service1.method");
    }

}
