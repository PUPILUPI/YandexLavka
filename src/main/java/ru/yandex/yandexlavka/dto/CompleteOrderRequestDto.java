package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CompleteOrderRequestDto(
        @JsonProperty("complete_info") List<CompleteOrderDto> completeInfo
) {}
