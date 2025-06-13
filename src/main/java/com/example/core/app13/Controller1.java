package com.example.core.app13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller1 {
    final Service1 svc;

    public Service1 getSvc() {
        return svc;
    }

    public void get() {
        svc.crud();
    }
}
