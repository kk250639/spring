package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repository.Entity27Repository;
import com.example.spring.repository.Entity28Repository;
import com.example.spring.repository.Entity29Repository;
import com.example.spring.repository.Entity30Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {

    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;
    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

    public void action1() {
        Entity27 c1 = new Entity27();
        Entity27 c2 = new Entity27();
        Entity27 c3 = new Entity27();

        c1.setCategoryName("음료수");
        c1.setInfo("설탕물");

        c2.setCategoryName("전자제품");
        c2.setInfo("전기를 사용하는 물건");

        c3.setCategoryName("청소용품");
        c3.setInfo("청소할 때 필요해");

        entity27Repository.save(c1);
        entity27Repository.save(c2);
        entity27Repository.save(c3);


    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1장");
        p6.setUnit("1대");

        Entity27 c1 = entity27Repository.findById(1).get();
        Entity27 c2 = entity27Repository.findById(2).get();
        Entity27 c3 = entity27Repository.findById(3).get();

        p1.setCategory(c3);
        p2.setCategory(c2);
        p3.setCategory(c1);
        p4.setCategory(c1);
        p5.setCategory(c3);
        p6.setCategory(c2);

        entity28Repository.save(p1);
        entity28Repository.save(p2);
        entity28Repository.save(p3);
        entity28Repository.save(p4);
        entity28Repository.save(p5);
        entity28Repository.save(p6);

    }

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);

    }

    public void action4(Integer id) {
        Entity28 entity28 = entity28Repository.findById(id).get();
        System.out.println("entity28 = " + entity28);
    }

    public void action5(Integer id) {
        Entity29 e1 = new Entity29();
        Entity29 e2 = new Entity29();
        Entity29 e3 = new Entity29();
        e1.setFirstName("son");
        e2.setFirstName("park");
        e3.setFirstName("cha");

        e1.setLastName("hm");
        e2.setLastName("js");
        e3.setLastName("bum");

        e1.setBirthDate(LocalDate.parse("2010-10-10"));
        e2.setBirthDate(LocalDate.parse("1999-09-09"));
        e3.setBirthDate(LocalDate.parse("1988-08-08"));

        entity29Repository.saveAll(List.of(e1, e2, e3));
    }

    public void action6(Integer id) {
        Entity30 q1 = new Entity30();
        Entity30 q2 = new Entity30();
        Entity30 q3 = new Entity30();
        Entity30 q4 = new Entity30();
        Entity30 q5 = new Entity30();
        Entity30 q6 = new Entity30();

        q1.setOrderDate(LocalDate.parse("2010-10-10"));
        q2.setOrderDate(LocalDate.parse("1999-09-09"));
        q3.setOrderDate(LocalDate.parse("1988-08-08"));
        q4.setOrderDate(LocalDate.parse("2010-10-10"));
        q5.setOrderDate(LocalDate.parse("1988-08-08"));
        q6.setOrderDate(LocalDate.parse("2010-10-10"));

        q1.setInfo("식료품 주문");
        q2.setInfo("청소 용품 주문");
        q3.setInfo("엘레베이터 없음");
        q4.setInfo("빨리 주세요");
        q5.setInfo("일회용품 필요");
        q6.setInfo("많이 주세요");

        Entity29 e1 = entity29Repository.findById(1).get();
        Entity29 e2 = entity29Repository.findById(2).get();
        Entity29 e3 = entity29Repository.findById(3).get();

        q1.setEmployee(e3);
        q2.setEmployee(e1);
        q3.setEmployee(e2);
        q4.setEmployee(e3);
        q5.setEmployee(e1);
        q6.setEmployee(e2);

        entity30Repository.saveAll(List.of(q1, q2, q3, q4, q5, q6));

    }

    public void action9(Integer id) {
        Entity30 o = entity30Repository.findById(id).get();

        System.out.println("o.getOrderDate() = " + o.getOrderDate());
        System.out.println("o.getInfo() = " + o.getInfo());

        // 직원정보
        System.out.println("o.getEmployee() = " + o.getEmployee());
    }
}

//    public void action3(Integer id) {
//        Entity27 entity27 = entity27Repository.findById(id).get();
//        System.out.println("entity27 = " + entity27);
//    }
//
//    public void action4(Integer id) {
//        Entity28 entity28 = entity28Repository.findById(id).get();
//        System.out.println("entity28 = " + entity28);
//    }
//    public void action5(Integer id) {
//        Entity29 e1 = new Entity29();
//        Entity29 e2 = new Entity29();
//        Entity29 e3 = new Entity29();
//
//        e1.setFirstName("kim");
//        e1.setLastName("java");
//        e1.setBrithDate(LocalDate.of(2010,2,3));
//        e2.setFirstName("kam");
//        e2.setLastName("java");
//        e2.setBrithDate(LocalDate.of(2010,3,5));
//        e3.setFirstName("kum");
//        e3.setLastName("java");
//        e3.setBrithDate(LocalDate.of(2093,3,1));
//
//        entity29Repository.save(e1);
//        entity29Repository.save(e2);
//        entity29Repository.save(e3);
//    }
//    public void action6(Integer id) {
//        Entity30 q1 = new Entity30();
//        Entity30 q2 = new Entity30();
//        Entity30 q3 = new Entity30();
//
//        q1.setInfo("f");
//        q1.setOrderDate(LoclaDate.of(2031,2,3));
//        q2.setInfo("w");
//        q2.setOrderDate(LocalDate.now());
//        q3.setInfo("e");
//        q3.setOrderDate(LocalDate.now());
//
//        entity30Repository.save(q1);
//        entity30Repository.save(q2);
//        entity30Repository.save(q3);
//    }
//    public void action7(Integer id) {
//        Entity29 entity29 = entity29Repository.findById(id).get();
//        System.out.println("entity29 = " + entity29);
//
//    }
//
//    public void action8(Integer id) {
//        Entity30 entity30 = entity30Repository.findById(id).get();
//        System.out.println("entity30 = " + entity30);
//    }
//
//
//}