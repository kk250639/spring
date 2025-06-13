package com.example.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bean2 {
    final Bean1 bean1;

    public void some() {
        bean1.crud();
    }
}
