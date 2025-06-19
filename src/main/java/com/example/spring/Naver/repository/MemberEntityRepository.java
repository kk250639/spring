package com.example.spring.Naver.repository;

import com.example.spring.Naver.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {
}