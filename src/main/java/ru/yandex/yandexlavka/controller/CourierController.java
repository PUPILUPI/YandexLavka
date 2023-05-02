package ru.yandex.yandexlavka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.CreateCourierRequestDto;
import ru.yandex.yandexlavka.dto.CreateCourierResponseDto;
import ru.yandex.yandexlavka.dto.CreatedCourierDto;
import ru.yandex.yandexlavka.dto.GetCouriersResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    private final static Random random = new Random();
    List<CreatedCourierDto> couriers = new ArrayList<>();

    @PostMapping
    public CreateCourierResponseDto createCouriers(@RequestBody CreateCourierRequestDto request) {
        var createdCouriers = request.couriers().stream().map(courier -> new CreatedCourierDto(
                random.nextLong(),
                courier.courierType(),
                courier.regions(),
                courier.workingHours())).toList();
        couriers.addAll(createdCouriers);
        return new CreateCourierResponseDto(createdCouriers);
    }

    @GetMapping
    public GetCouriersResponseDto getCouriersResponse(@RequestParam(defaultValue = "1") int limit,
                                                      @RequestParam(defaultValue = "0") int offset) {
        var result = this.couriers.subList(offset, offset + limit);
        return new GetCouriersResponseDto(result, limit, offset);
    }

    @GetMapping("/{courier_id}")
    public ResponseEntity<CreatedCourierDto> getCourier(@PathVariable("courier_id") long id) {
        var courierById = couriers.stream()
                .filter(courier -> id == courier.courierId())
                .findAny();
        return courierById.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
