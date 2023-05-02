package ru.yandex.yandexlavka.dto;

import java.util.List;

public record CreateOrderRequestDto(List<CreateOrderDto> orders) {
}
