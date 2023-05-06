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
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;
    @Column(name = "from")
    private LocalTime from;
    @Column(name = "to")
    private LocalTime to;
}
