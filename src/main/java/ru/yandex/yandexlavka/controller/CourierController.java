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
                .map(courier -> {
                    Courier newCourier = Courier.builder()
                            .type(CourierType.valueOf(courier.courierTypeDto().name()))
                            .regions(convertToCourierRegions(courier.regions()))
                            .workingHours(convertToCourierSchedule(courier.workingHours()))
                            .build();
                    newCourier.getRegions().forEach(region -> region.setCourier(newCourier));
                    newCourier.getWorkingHours().forEach(interval -> interval.setCourier(newCourier));
                    return newCourier;
                })
                .toList();
//        получаем на вход CreateCourierRequestDto, должны вернуть CreateCourierResponseDto
//        берем из CreateCourierRequestDto request List<CreateCourierDto> couriers и конвертируем из CreateCourierDto
//        Courier, затем сохраняем их в бд и должны вернуть CreateCourierResponseDto,
//        который содержит в себе CreatedCourierDto
        var createdCouriers = service.createCouriers(couriers)
                .stream()
                .map(courier -> new CreatedCourierDto(
                        courier.getId(),
                        CourierTypeDto.valueOf(courier.getType().name()),
                        convertToCourierRegionDto(courier.getRegions()),
                        convertToCourierScheduleDto(courier.getWorkingHours())))
                .toList();
        return new CreateCourierResponseDto(createdCouriers);
    }

    @GetMapping
    public GetCouriersResponseDto getCouriersResponse(@RequestParam(defaultValue = "1") int limit,
                                                      @RequestParam(defaultValue = "0") int offset) {
        var result = service.getCouriers(limit, offset)
                .stream()
                .map(courier -> new CreatedCourierDto(
                        courier.getId(),
                        CourierTypeDto.valueOf(courier.getType().name()),
                        convertToCourierRegionDto(courier.getRegions()),
                        convertToCourierScheduleDto(courier.getWorkingHours())))
                .toList();
        return new GetCouriersResponseDto(result, limit, offset);
    }

    @GetMapping("/{courier_id}")
    public ResponseEntity<CreatedCourierDto> getCourier(@PathVariable("courier_id") long id) {
        var courierById = service.getCourier(id);
        return courierById.map(courier -> new CreatedCourierDto(
                        courier.getId(),
                        CourierTypeDto.valueOf(courier.getType().name()),
                        convertToCourierRegionDto(courier.getRegions()),
                        convertToCourierScheduleDto(courier.getWorkingHours())))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public static Set<CourierRegion> convertToCourierRegions(Set<Integer> regions) {
        return regions.stream()
                .map(region -> CourierRegion.builder()
                        .zipcode(region)
                        .build())
                .collect(Collectors.toSet());
    }

    public static Set<CourierSchedule> convertToCourierSchedule(Set<String> workingHours) {
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

    public static Set<String> convertToCourierScheduleDto(Set<CourierSchedule> workingHours) {
        return workingHours.stream()
                .map(interval -> interval.getFrom() + "-" + interval.getTo())
                .collect(Collectors.toSet());
    }

    public static Set<Integer> convertToCourierRegionDto(Set<CourierRegion> regions) {
        return regions.stream()
                .map(CourierRegion::getZipcode)
                .collect(Collectors.toSet());
    }
}
