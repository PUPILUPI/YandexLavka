package ru.yandex.yandexlavka.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    @Query(value = "SELECT * FROM orders ORDER BY id LIMIT :limit OFFSET :offset",
            nativeQuery = true)
    List<Order> getOrders(final int limit, final int offset);
    @Query("""
            SELECT COUNT(o) FROM Order o
            WHERE o.courier = :courier
                AND o.completedTime BETWEEN :startDate AND :endDate
            """)
    int countOrders(Courier courier, LocalDateTime startDate, LocalDateTime endDate);
    @Query("""
            SELECT SUM(o.cost * :earningsCoefficient) FROM Order o
            WHERE o.courier = :courier
                AND o.completedTime BETWEEN :startDate AND :endDate
            """)
    int calculateEarnings(Courier courier, int earningsCoefficient, LocalDateTime startDate, LocalDateTime endDate);
    int countByCourierAndCompletedTimeBetween(Courier courier, LocalDateTime startDate, LocalDateTime endDate);
}
