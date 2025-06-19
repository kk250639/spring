package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table36")
@Getter
@Setter
@ToString
public class Entity36 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate registeredAt;
    private String enabled;
    private String money;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Entity34 student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_Id")
    private Entity35 lecture;

}

//package com.example.spring.entity;
//
//import jakarta.persistence .*;
//        import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "my_table36", schema = "jpa")
//public class Entity36 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @Column(name = "registered_at")
//    private LocalDate registeredAt;
//
//    @Column(name = "enabled", length = 1)
//    private String enabled;
//
//    @Column(name = "money", length = 1)
//    private String money;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "student_id", nullable = false)
//    private Entity34 student;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "lecture_id", nullable = false)
//    private Entity35 lecture;
//
//}