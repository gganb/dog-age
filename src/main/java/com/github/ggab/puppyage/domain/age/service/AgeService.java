package com.github.ggab.puppyage.domain.age.service;

import com.github.ggab.puppyage.domain.age.dto.request.AgeRequestDto;
import com.github.ggab.puppyage.domain.age.dto.response.AgeResponseDto;
import com.github.ggab.puppyage.domain.age.entity.DogAge;
import com.github.ggab.puppyage.domain.age.enums.DogSize;
import com.github.ggab.puppyage.domain.age.repository.AgeRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class AgeService {

    private final AgeRepository repository;

    @Transactional
    public AgeResponseDto circulateAge(AgeRequestDto requestDto) {

        LocalDate dogBirth = requestDto.getBirth();
        LocalDate today = LocalDate.now();
        DogSize dogSize = requestDto.getDogSize();
        Integer inputAge = requestDto.getAge();

        long monthAge;

        if (dogBirth != null) {

            // 생일 기준 강아지 나이 계산
            if (dogBirth.isAfter(today)) {
                throw new IllegalArgumentException("생일이 현재 날짜보다 이후일 수 없습니다.");
            }

            monthAge = calculateDogAge(dogBirth, today);

        } else if (inputAge != null) {
            monthAge = inputAge * 12L;
        } else {
            throw new IllegalArgumentException("생일 또는 나이 둘 중 하나는 반드시 입력해야합니다.");
        }

        int dogAge = (int) (monthAge / 12);

        // 사람 나이 계산
        int humanAge = dogSize.calculateHumanAge((int)monthAge);

        DogAge age = requestDto.toEntity(dogSize, dogBirth, requestDto.getName(), dogAge);

        repository.save(age);

        return AgeResponseDto.of(age, humanAge);
    }

    // 강아지 나이 계산
    private long calculateDogAge(LocalDate birth, LocalDate today) {
        return ChronoUnit.MONTHS.between(birth, today);
    }
}
