package com.github.ggab.puppyage.domain.age.enums;

public enum DogSize {
    /**
     * 나이가 2살 이하일 경우 1살 : 15살 , 2살 : 24살
     * <p>
     * 3살 이후 소형견 : 4살 추가, 중형견 : 5살 추가, 대형견 : 6살 추가
     */
    SMALL(4), MEDIUM(5), LARGE(6);

    private final int yearlyAddition;

    DogSize(int yearlyAddition) {
        this.yearlyAddition = yearlyAddition;
    }

    public int calculateHumanAge(int dogAge) {
        if (dogAge == 1) {
            return 15;
        }
        if (dogAge == 2) {
            return 24;
        }
        return 24 + (dogAge - 2) * yearlyAddition;
    }
}
