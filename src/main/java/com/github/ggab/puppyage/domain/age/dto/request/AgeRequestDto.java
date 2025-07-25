package com.github.ggab.puppyage.domain.age.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ggab.puppyage.domain.age.entity.DogAge;
import com.github.ggab.puppyage.domain.age.enums.DogSize;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class AgeRequestDto {

    private String name; // 이름

    private DogSize dogSize; // 강아지 크기

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth; // 생일

    private Integer age; // 나이 (생일을 모를 경우)

    public DogAge toEntity(DogSize dogSize, LocalDate birth, String name, int dogAge) {
        return DogAge.builder()
                .dogSize(dogSize)
                .birth(birth)
                .name(name)
                .dogAge(dogAge)
                .build();
    }

}
