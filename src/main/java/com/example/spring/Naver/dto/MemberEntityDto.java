package com.example.spring.Naver.dto;

import com.example.spring.Naver.entity.MemberEntity;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link MemberEntity}
 */
@Value
public class MemberEntityDto implements Serializable {
    Integer id;
    String nickname;
    LocalDateTime createdAt;
}