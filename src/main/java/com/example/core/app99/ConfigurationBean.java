package com.example.core.app99;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ConfigurationBean {
    public static void main(String[] args) {
        var context = SpringApplication.run(ConfigurationBean.class, args);
        Beanq bq = context.getBean(Beanq.class);
        Object bean = context.getBean("makewbean");
        Beanw bw = bq.getBw();
        System.out.println(bean == bw);
        bq.walk();
    }

}

@Configuration
class Cfgr {
    @Bean
    public Beanw makewbean() {
        return new Beanw();
    }
    @Bean
    public Beanw1 makewbean2() {
        return new Beanw1();
    }
}

@Component
@RequiredArgsConstructor
class Beanq {
    final Beanw bw;

    public Beanw getBw() {
        return bw;
    }

    public void walk() {
        bw.run();
    }
}

class Beanw {
    public void run() {
        System.out.println("Beanw.run");
    }
}

