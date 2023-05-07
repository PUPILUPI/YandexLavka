package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record CreateCourierDto(
        @JsonProperty("courier_type") CourierTypeDto courierTypeDto,
        @JsonProperty("regions") Set<Integer> regions,
        @JsonProperty("working_hours") Set<String> workingHours
) {}
