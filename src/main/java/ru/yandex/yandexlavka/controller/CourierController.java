package ru.yandex.yandexlavka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.db.entity.*;
import ru.yandex.yandexlavka.dto.*;
import ru.yandex.yandexlavka.service.CourierService;
import ru.yandex.yandexlavka.util.RateLimiterDecorator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService service;
    private final RateLimiterDecorator rateLimiterDecorator;

    @PostMapping
    public ResponseEntity<CreateCourierResponseDto> createCouriers(@RequestBody CreateCourierRequestDto request) {
        return rateLimiterDecorator.execute("rateLimiter-createCouriers", () -> {
            var couriers = request.couriers().stream()
                    .map(CourierController::convertToCourier)
                    .toList();
            var createdCouriers = service.createCouriers(couriers)
                    .stream()
                    .map(CourierController::convertToCreatedCourierDto)
                    .toList();
            return ResponseEntity.ok(new CreateCourierResponseDto(createdCouriers));
        });
    }

    @GetMapping
    public ResponseEntity<GetCouriersResponseDto> getCouriersResponse(@RequestParam(defaultValue = "1") int limit,
                                                                      @RequestParam(defaultValue = "0") int offset) {
        return rateLimiterDecorator.execute("rateLimiter-getCouriersResponse", () -> {
            var result = service.getCouriers(limit, offset)
                    .stream()
                    .map(CourierController::convertToCreatedCourierDto)
                    .toList();
            return ResponseEntity.ok(new GetCouriersResponseDto(result, limit, offset));
        });
    }

    @GetMapping("/{courier_id}")
    public ResponseEntity<CreatedCourierDto> getCourier(@PathVariable("courier_id") long id) {
        return rateLimiterDecorator.execute("rateLimiter-getCourier", () -> {
            var courierById = service.getCourier(id);
            return courierById.map(CourierController::convertToCreatedCourierDto)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        });
    }

    @GetMapping("/meta-info/{courier_id}")
    public ResponseEntity<GetCourierMetaInfoResponseDto> getCourierMetaInfoResponseDto(@PathVariable("courier_id") long courierId,
                                                                                       @RequestParam String startDate,
                                                                                       @RequestParam String endDate) {
        return rateLimiterDecorator.execute("rateLimiter-getCourierMetaInfoResponseDto", () -> {
            Optional<Courier> courierByID = service.getCourier(courierId);
            if (courierByID.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Courier courier = courierByID.get();
            CourierMetaInfo metaInfo = service.calculateMetaInfo(courier,
                    LocalDate.parse(startDate).atStartOfDay(),
                    LocalDate.parse(endDate).atStartOfDay());
            GetCourierMetaInfoResponseDto info = new GetCourierMetaInfoResponseDto(
                    courier.getId(),
                    CourierTypeDto.valueOf(courier.getType().name()),
                    convertToCourierRegionDto(courier.getRegions()),
                    convertToCourierScheduleDto(courier.getWorkingHours()),
                    metaInfo.rating(),
                    metaInfo.earnings()
            );
            return ResponseEntity.ok(info);
        });
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
