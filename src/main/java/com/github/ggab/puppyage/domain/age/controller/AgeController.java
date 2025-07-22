package com.github.ggab.puppyage.domain.age.controller;

import com.github.ggab.puppyage.domain.age.dto.request.AgeRequestDto;
import com.github.ggab.puppyage.domain.age.dto.response.AgeResponseDto;
import com.github.ggab.puppyage.domain.age.service.AgeService;
import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/age")
@AllArgsConstructor
public class AgeController {

    private final AgeService ageService;

    @PostMapping
    public ResponseEntity<AgeResponseDto> circulateAge(
            @RequestBody AgeRequestDto requestDto
    ) {
        AgeResponseDto responseDto = ageService.circulateAge(requestDto);
        return ResponseEntity.created(URI.create("/api/age")).body(responseDto);
    }
}
