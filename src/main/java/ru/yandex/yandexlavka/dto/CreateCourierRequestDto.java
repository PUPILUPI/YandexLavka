package ru.yandex.yandexlavka.dto;

import java.util.List;

public record CreateCourierRequestDto(List<CreateCourierDto> couriers) {}
