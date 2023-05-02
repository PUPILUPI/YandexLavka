package ru.yandex.yandexlavka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.CreateOrderRequestDto;
import ru.yandex.yandexlavka.dto.CreatedOrderDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final static Random random = new Random();
    List<CreatedOrderDto> orders = new ArrayList<>();

    @GetMapping("/{order_id}")
    public ResponseEntity<CreatedOrderDto> getOrder(@PathVariable("order_id") long orderId) {
        var orderByID = orders.stream()
                .filter(order -> orderId == order.id())
                .findAny();
        return orderByID.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CreatedOrderDto> getOrdersResponse(@RequestParam(defaultValue = "1") int limit,
                                                   @RequestParam(defaultValue = "0") int offset) {
        return this.orders.subList(offset, offset + limit);

    }

    @PostMapping
    public List<CreatedOrderDto> createOrderRequestDto(@RequestBody CreateOrderRequestDto request) {
        var createdOrders = request.orders().stream().map(order -> new CreatedOrderDto(
                random.nextLong(),
                order.weight(),
                order.region(),
                order.deliveryHours(),
                order.cost(),
                null)).toList();
        orders.addAll(createdOrders);
        return createdOrders;
    }
}
