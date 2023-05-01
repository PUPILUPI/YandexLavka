package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record CreatedCourierDto(
        @JsonProperty("courier_id") long courierId,
        @JsonProperty("courier_type") CourierTypeDto courierType,
        @JsonProperty("regions") List<Integer> regions,
        @JsonProperty("working_hours") List<String> workingHours
){}
