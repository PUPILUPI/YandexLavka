package ru.yandex.yandexlavka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.dto.CreateCourierRequestDto;
import ru.yandex.yandexlavka.dto.CreateCourierResponseDto;
import ru.yandex.yandexlavka.dto.CreatedCourierDto;
import ru.yandex.yandexlavka.dto.GetCouriersResponseDto;
import ru.yandex.yandexlavka.service.CourierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService service;
    private final static Random random = new Random();
    List<CreatedCourierDto> couriers = new ArrayList<>();

    @PostMapping
    public CreateCourierResponseDto createCouriers(@RequestBody CreateCourierRequestDto request) {
        var couriers = request.couriers().stream()
                .map(courier -> Courier.builder()
                        .type(courier.courierType())
                        .regions(Set.of())
                        .workingHours(List.of())
                        .build())
                .toList();
//        получаем на вход CreateCourierRequestDto, должны вернуть CreateCourierResponseDto
//        берем из CreateCourierRequestDto request List<CreateCourierDto> couriers и конвертируем из CreateCourierDto
//        Courier, затем сохраняем их в бд и должны вернуть CreateCourierResponseDto,
//        который содержит в себе CreatedCourierDto
        var createdCouriers = service.createCouriers(couriers)
                .stream()
                .map(courier -> new CreatedCourierDto(
                        courier.getId(),
                        courier.getType(),
                        courier.getRegions().stream().map(it -> it.getZipcode()).toList(),
                        List.of()))
                .toList();
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
