package ru.yandex.yandexlavka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.yandexlavka.dto.CreateCourierRequestDto;
import ru.yandex.yandexlavka.dto.CreateCourierResponseDto;
import ru.yandex.yandexlavka.dto.CreatedCourierDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    private static Random random = new Random();
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
}
