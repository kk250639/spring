package com.example.spring.service;

import com.example.spring.entity.Entity21;
import com.example.spring.repository.Entity21Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class Service6 {

    private final Entity21Repository entity21Repository;


    public void action1(String name, String address) {
        Entity21 data = new Entity21();
        data.setName(name);
        data.setAddress(address);
//        data.setInsertedAt(LocalDateTime.now());
        entity21Repository.save(data);
    }
}