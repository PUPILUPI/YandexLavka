package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record CreatedOrderDto(
        @JsonProperty("order_id") long id,
        @JsonProperty("weight") float weight,
        @JsonProperty("regions") int region,
        @JsonProperty("delivery_hours") Set<String> deliveryHours,
        @JsonProperty("cost") int cost,
        @JsonProperty("completed_time") String completedTime

) {}
