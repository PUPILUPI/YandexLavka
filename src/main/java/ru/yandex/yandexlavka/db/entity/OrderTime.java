package ru.yandex.yandexlavka.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "order_time")
@EqualsAndHashCode(exclude = "order")
public class OrderTime {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @Column(name = "from")
    private LocalTime from;
    @Column(name = "to")
    private LocalTime to;
}
