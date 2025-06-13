package com.example.core.app9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Comp2 {
    Comp1 comp1;

    @Autowired
    public Comp2(Comp1 comp1) {
        this.comp1 = comp1;
    }

    public void action1() {
        comp1.test();
    }
}
