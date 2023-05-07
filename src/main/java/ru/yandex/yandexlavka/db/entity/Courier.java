package ru.yandex.yandexlavka.db.entity;

import jakarta.persistence.*;
import lombok.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "courier_type")
    @Enumerated(EnumType.STRING)
    private CourierType type;
    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CourierRegion> regions;
    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CourierSchedule> workingHours;
}
