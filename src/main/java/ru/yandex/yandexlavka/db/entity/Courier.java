package ru.yandex.yandexlavka.db.entity;

import lombok.*;
import ru.yandex.yandexlavka.dto.CourierTypeDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Courier {
    private Long id;
    private CourierTypeDto type;
    private List<Integer> regions;
    private List<String> workingHours;
}
