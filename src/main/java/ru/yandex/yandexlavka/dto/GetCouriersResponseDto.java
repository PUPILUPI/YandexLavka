package ru.yandex.yandexlavka.dto;

import java.util.List;

public record GetCouriersResponseDto(
        List<CreatedCourierDto> couriers,
        int limit,
        int offset
        ) {}
