package com.example.spring.Naver.dto;

import com.example.spring.Naver.entity.PostEntity;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link PostEntity}
 */
@Value
public class PostEntityDto implements Serializable {
    Integer id;
    String title;
    Integer writerId;
    String writerNickname;
    LocalDateTime writerCreatedAt;
}