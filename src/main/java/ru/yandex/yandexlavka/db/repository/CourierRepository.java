package ru.yandex.yandexlavka.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.yandexlavka.db.entity.Courier;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
