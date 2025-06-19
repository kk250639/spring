package com.example.spring.Naver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Member", schema = "jpa")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 10)
    private String username;

    @Column(name = "password", length = 16)
    private String password;

    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}