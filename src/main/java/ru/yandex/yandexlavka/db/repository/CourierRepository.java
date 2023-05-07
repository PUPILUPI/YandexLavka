package ru.yandex.yandexlavka.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.db.entity.Courier;

import java.util.Collection;
import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    @Query(value = "SELECT * FROM couriers ORDER BY id LIMIT :limit OFFSET :offset",
            nativeQuery = true)
    List<Courier> getCouriers(final int limit, final int offset);
}