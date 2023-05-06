package ru.yandex.yandexlavka.db.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "courier_regions")
@EqualsAndHashCode(exclude = "courier")
public class CourierRegion {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;
    @Column(name = "zipcode")
    private int zipcode;

}
