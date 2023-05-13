package ru.yandex.yandexlavka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.db.entity.Order;
import ru.yandex.yandexlavka.db.entity.OrderTime;
import ru.yandex.yandexlavka.dto.*;
import ru.yandex.yandexlavka.service.OrderService;
import ru.yandex.yandexlavka.util.RateLimiterDecorator;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    private final RateLimiterDecorator rateLimiterDecorator;

    @GetMapping("/{order_id}")
    public ResponseEntity<CreatedOrderDto> getOrder(@PathVariable("order_id") long orderId) {
        return rateLimiterDecorator.execute("rateLimiter-getOrder", () -> {
            Optional<Order> orderByID = service.getOrderById(orderId);
            return orderByID.map(OrderController::convertToOrderDto)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        });
    }

    @GetMapping
    public ResponseEntity<List<CreatedOrderDto>> getOrdersResponse(@RequestParam(defaultValue = "1") int limit,
                                                                   @RequestParam(defaultValue = "0") int offset) {
        return rateLimiterDecorator.execute("rateLimiter-getOrder", () -> {
            var orders = service.getOrders(limit, offset);
            return ResponseEntity.ok(orders.stream()
                    .map(OrderController::convertToOrderDto)
                    .toList());
        });
    }

    @PostMapping
    public ResponseEntity<List<CreatedOrderDto>> createOrderRequestDto(@RequestBody CreateOrderRequestDto request) {
        return rateLimiterDecorator.execute("rateLimiter-getOrder", () -> {
            var orders = request.orders().stream()
                    .map(orderDto -> {
                        var order = convertToOrder(orderDto);
                        order.getDeliveryHours().forEach(time -> time.setOrder(order));
                        return order;
                    })
                    .toList();

            var saved = service.saveOrders(orders);
            return ResponseEntity.ok(saved.stream()
                    .map(OrderController::convertToOrderDto)
                    .toList());
        });
    }

    @PostMapping("/complete")
    public ResponseEntity<List<CreatedOrderDto>> completeOrder(@RequestBody CompleteOrderRequestDto requestDto) {
        return rateLimiterDecorator.execute("rateLimiter-getOrder", () -> {
            List<Long> ids = requestDto.completeInfo().stream().map(CompleteOrderDto::orderId).toList();
            var orderDtoById = requestDto.completeInfo().stream().collect(Collectors.toMap(CompleteOrderDto::orderId, completeOrderDto -> completeOrderDto));
            var orders = service.getOrders(ids);
            if (requestDto.completeInfo().size() != orders.size()) {
                return ResponseEntity.badRequest().build();
            }
            boolean hasBadRequest = orders.stream()
                    .anyMatch(order ->
                            order.getCourier() == null || orderDtoById.get(order.getId()).courierId() != order.getCourier().getId()
                    );
            if (hasBadRequest) {
                return ResponseEntity.badRequest().build();
            } else {
                orders.forEach(order -> order.setCompletedTime(LocalDateTime.parse(orderDtoById.get(order.getId()).completedTime(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)));
                var ordersWithId = service.updateCompleteTime(orders);
                var result = ordersWithId.stream().map(OrderController::convertToOrderDto).toList();
                return ResponseEntity.ok(result);
            }
        });

    }

    private static Order convertToOrder(CreateOrderDto orderDto) {
        return Order.builder()
                .weight(orderDto.weight())
                .region(orderDto.region())
                .cost(orderDto.cost())
                .deliveryHours(convertToOrderTime(orderDto.deliveryHours()))
                .build();
    }

    private static CreatedOrderDto convertToOrderDto(Order order) {
        String completedTime = null;
        if (order.getCompletedTime() != null) {
            completedTime = order.getCompletedTime().toInstant(ZoneOffset.UTC).toString();
        }
        return new CreatedOrderDto(
                order.getId(),
                order.getWeight(),
                order.getRegion(),
                convertToOrderTimeDto(order.getDeliveryHours()),
                order.getCost(),
                completedTime
        );
    }

    private static Set<String> convertToOrderTimeDto(Set<OrderTime> intervals) {
        return intervals.stream()
                .map(interval -> interval.getFrom() + "-" + interval.getTo())
                .collect(toSet());
    }

    private static Set<OrderTime> convertToOrderTime(Set<String> intervals) {
        return intervals.stream()
                .map(interval -> {
                    String[] time = interval.split("-");
                    return OrderTime.builder()
                            .from(LocalTime.parse(time[0]))
                            .to(LocalTime.parse(time[1]))
                            .build();
                })
                .collect(toSet());
    }

}
