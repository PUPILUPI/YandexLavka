package ru.yandex.yandexlavka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.entity.CourierRegion;
import ru.yandex.yandexlavka.db.entity.CourierSchedule;
import ru.yandex.yandexlavka.db.entity.CourierType;
import ru.yandex.yandexlavka.dto.*;
import ru.yandex.yandexlavka.service.CourierService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService service;
    List<CreatedCourierDto> couriers = new ArrayList<>();

    @PostMapping
    public CreateCourierResponseDto createCouriers(@RequestBody CreateCourierRequestDto request) {
        var couriers = request.couriers().stream()
                .map(CourierController::convertToCourier)
                .toList();
//        получаем на вход CreateCourierRequestDto, должны вернуть CreateCourierResponseDto
//        берем из CreateCourierRequestDto request List<CreateCourierDto> couriers и конвертируем из CreateCourierDto
//        Courier, затем сохраняем их в бд и должны вернуть CreateCourierResponseDto,
//        который содержит в себе CreatedCourierDto
        var createdCouriers = service.createCouriers(couriers)
                .stream()
                .map(CourierController::convertToCreatedCourierDto)
                .toList();
        return new CreateCourierResponseDto(createdCouriers);
    }

    @GetMapping
    public GetCouriersResponseDto getCouriersResponse(@RequestParam(defaultValue = "1") int limit,
                                                      @RequestParam(defaultValue = "0") int offset) {
        var result = service.getCouriers(limit, offset)
                .stream()
                .map(CourierController::convertToCreatedCourierDto)
                .toList();
        return new GetCouriersResponseDto(result, limit, offset);
    }

    @GetMapping("/{courier_id}")
    public ResponseEntity<CreatedCourierDto> getCourier(@PathVariable("courier_id") long id) {
        var courierById = service.getCourier(id);
        return courierById.map(CourierController::convertToCreatedCourierDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private static Set<CourierRegion> convertToCourierRegions(Set<Integer> regions) {
        return regions.stream()
                .map(region -> CourierRegion.builder()
                        .zipcode(region)
                        .build())
                .collect(Collectors.toSet());
    }

    private static Set<CourierSchedule> convertToCourierSchedule(Set<String> workingHours) {
        return workingHours.stream()
                .map(interval -> {
                    String[] time = interval.split("-");
                    return CourierSchedule.builder()
                            .from(LocalTime.parse(time[0]))
                            .to(LocalTime.parse(time[1]))
                            .build();
                })
                .collect(Collectors.toSet());
    }

    private static Set<String> convertToCourierScheduleDto(Set<CourierSchedule> workingHours) {
        return workingHours.stream()
                .map(interval -> interval.getFrom() + "-" + interval.getTo())
                .collect(Collectors.toSet());
    }

    private static Set<Integer> convertToCourierRegionDto(Set<CourierRegion> regions) {
        return regions.stream()
                .map(CourierRegion::getZipcode)
                .collect(Collectors.toSet());
    }

    private static Courier convertToCourier(CreateCourierDto courierDto) {
        Courier newCourier = Courier.builder()
                .type(CourierType.valueOf(courierDto.courierTypeDto().name()))
                .regions(convertToCourierRegions(courierDto.regions()))
                .workingHours(convertToCourierSchedule(courierDto.workingHours()))
                .build();
        newCourier.getRegions().forEach(region -> region.setCourier(newCourier));
        newCourier.getWorkingHours().forEach(interval -> interval.setCourier(newCourier));
        return newCourier;
    }

    private static CreatedCourierDto convertToCreatedCourierDto(Courier courier) {
        return new CreatedCourierDto(
                courier.getId(),
                CourierTypeDto.valueOf(courier.getType().name()),
                convertToCourierRegionDto(courier.getRegions()),
                convertToCourierScheduleDto(courier.getWorkingHours()));
    }
}
