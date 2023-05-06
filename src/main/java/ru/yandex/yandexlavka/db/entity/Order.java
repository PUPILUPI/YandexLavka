package ru.yandex.yandexlavka.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "weight")
    float weight;
    @Column(name = "regions")
    int region;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    Set<OrderTime> deliveryHours;
    @Column(name = "cost")
    int cost;
    @Column(name = "completed_time")
    String completedTime;
}
