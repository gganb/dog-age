package com.github.ggab.puppyage.domain.age.repository;

import com.github.ggab.puppyage.domain.age.entity.DogAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRepository extends JpaRepository<DogAge, Long> {

}
