package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record GetCourierMetaInfoResponseDto(
        @JsonProperty("courier_id") long courierId,
        @JsonProperty("courier_type") CourierTypeDto courierTypeDto,
        @JsonProperty("regions") Set<Integer> regions,
        @JsonProperty("working_hours") Set<String> workingHours,
        @JsonProperty("rating")  Integer rating,
        @JsonProperty("earnings") Integer earnings

) {}