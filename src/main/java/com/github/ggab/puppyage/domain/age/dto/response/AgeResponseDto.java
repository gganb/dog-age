package com.github.ggab.puppyage.domain.age.dto.response;

import com.github.ggab.puppyage.domain.age.entity.DogAge;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AgeResponseDto {

    private Long dogId;
    private String name;
    private LocalDate birth;
    private int dogAge;
    // 환산 나이
    private int humanAge;

    public static AgeResponseDto of(DogAge age, int humanAge) {

        return AgeResponseDto.builder()
                .dogId(age.getId())
                .name(age.getName())
                .birth(age.getBirth())
                .dogAge(age.getDogAge())
                .humanAge(humanAge)
                .build();
    }
}
