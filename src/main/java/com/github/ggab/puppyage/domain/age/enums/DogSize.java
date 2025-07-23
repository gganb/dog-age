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

    public int calculateHumanAge(int monthAge) {
        if(monthAge < 0){
            throw new IllegalArgumentException("월령은 음수일 수 없습니다.");
        }
        if (monthAge <= 1) return 1;
        if (monthAge <= 2) return 3;
        if (monthAge <= 3) return 5;
        if (monthAge <= 6) return 10;
        if (monthAge <= 9) return 14;
        if (monthAge <= 12) return 15;
        if (monthAge <= 18) return 20;
        if (monthAge <= 24) return 24;

        int additional = (monthAge - 24) / 12;

        return 24 + additional * yearlyAddition;
    }
}
