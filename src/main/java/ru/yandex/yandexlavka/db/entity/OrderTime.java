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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @Column(name = "from_time")
    private LocalTime from;
    @Column(name = "to_time")
    private LocalTime to;
}
