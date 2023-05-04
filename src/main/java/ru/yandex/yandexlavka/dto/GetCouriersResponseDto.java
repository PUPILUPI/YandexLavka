package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetCouriersResponseDto(
        @JsonProperty("couriers") List<CreatedCourierDto> couriers,
        @JsonProperty("limit") int limit,
        @JsonProperty("offset") int offset
        ) {}
