package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateCourierResponseDto(
        @JsonProperty("couriers") List<CreatedCourierDto> couriers) {}
