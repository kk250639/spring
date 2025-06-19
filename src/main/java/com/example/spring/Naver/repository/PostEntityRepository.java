package com.example.spring.Naver.repository;

import com.example.spring.Naver.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostEntityRepository extends JpaRepository<PostEntity, Integer> {
}