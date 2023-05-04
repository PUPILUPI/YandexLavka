package ru.yandex.yandexlavka.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    Long id;
    float weight;
    int region;
    List<String> deliveryHours;
    int cost;
    String completedTime;
}
