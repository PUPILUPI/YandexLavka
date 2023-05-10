package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompleteOrderDto(
        @JsonProperty("courier_id") long courierId,
        @JsonProperty("order_id") long orderId,
        @JsonProperty("complete_time") String completedTime
) {}
