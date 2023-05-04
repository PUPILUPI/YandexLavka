package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateCourierRequestDto(
        @JsonProperty("couriers") List<CreateCourierDto> couriers
) {}
