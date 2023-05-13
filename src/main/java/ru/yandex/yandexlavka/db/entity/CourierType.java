package ru.yandex.yandexlavka.db.entity;

import lombok.Getter;

@Getter
public enum CourierType {
    FOOT(3, 2),
    BIKE(2, 3),
    AUTO(1, 4);
    private final int ratingCoefficient;
    private final int earningsCoefficient;

    CourierType(int ratingCoefficient, int earningsCoefficient) {
        this.ratingCoefficient = ratingCoefficient;
        this.earningsCoefficient = earningsCoefficient;
    }
}
