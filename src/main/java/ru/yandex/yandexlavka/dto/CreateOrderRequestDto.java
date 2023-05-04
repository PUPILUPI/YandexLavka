package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateOrderRequestDto(
        @JsonProperty("orders") List<CreateOrderDto> orders
) {}
