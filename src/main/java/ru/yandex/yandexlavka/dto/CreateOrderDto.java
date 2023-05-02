package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateOrderDto(
        @JsonProperty("weight") float weight,
        @JsonProperty("regions") int region,
        @JsonProperty("delivery_hours") List<String> deliveryHours,
        @JsonProperty("cost") int cost
        ) {}
