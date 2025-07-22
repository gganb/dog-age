package com.github.ggab.puppyage.domain.age.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ggab.puppyage.domain.age.entity.Age;
import com.github.ggab.puppyage.domain.age.enums.DogSize;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class AgeRequestDto {

    private String name; // 이름


    private DogSize dogSize; // 강아지 크기

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birth; // 생일

    private Integer age; // 나이 (생일을 모를 경우)

    public Age toEntity(DogSize dogSize, LocalDateTime birth, String name, int dogAge) {
        return Age.builder()
                .dogSize(dogSize)
                .birth(birth)
                .name(name)
                .dogAge(dogAge)
                .build();
    }

}
