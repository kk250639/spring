package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table35")
@Setter
@Getter
@ToString
public class Entity35 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lectureTitle;
    private String info;
    private String place;
}
//package com.example.spring.entity;
//
//import jakarta.persistence.*;
//        import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "my_table35", schema = "jpa")
//public class Entity35 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @Column(name = "lecture_title", length = 30)
//    private String lectureTitle;
//
//    @Column(name = "info", length = 50)
//    private String info;
//
//    @Column(name = "place", length = 50)
//    private String place;
//
//}
