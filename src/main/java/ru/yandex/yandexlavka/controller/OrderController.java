package ru.yandex.yandexlavka.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static Random random = new Random();
    List<CreatedOrderDto> orders = new ArrayList<CreatedOrderDto>();
    @GetMapping("/{order_id}")
    public CreatedOrderDto getOrder(@PathVariable("order_id") long orderId) {
        return orders.stream()
                .filter(order -> orderId == order.id())
                .findAny()
                .orElse(null);
    }
    @GetMapping
    public List<CreatedOrderDto> getOrdersResponse(@RequestParam(defaultValue = "1") int limit,
                                                   @RequestParam(defaultValue = "0") int offset) {
        var result = this.orders.subList(offset, offset + limit);
        return result;
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
