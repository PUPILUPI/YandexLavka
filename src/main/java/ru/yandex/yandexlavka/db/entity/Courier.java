package ru.yandex.yandexlavka.db.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.yandex.yandexlavka.dto.CourierTypeDto;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "couriers")
public class Courier {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "courier_type")
    private CourierTypeDto type;
    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY)
    private Set<CourierRegion> regions;
    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY)
    private List<CourierSchedule> workingHours;
}
