package ru.yandex.yandexlavka.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.db.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    @Query(value = "SELECT * FROM orders ORDER BY id LIMIT :limit OFFSET :offset",
            nativeQuery = true)
    List<Order> getOrders(final int limit, final int offset);
}
