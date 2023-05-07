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
@Table(name = "courier_schedule")
@EqualsAndHashCode(exclude = "courier")
public class CourierSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;
    @Column(name = "from_time")
    private LocalTime from;
    @Column(name = "to_time")
    private LocalTime to;
}
