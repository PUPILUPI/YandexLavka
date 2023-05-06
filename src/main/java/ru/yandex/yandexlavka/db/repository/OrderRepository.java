package ru.yandex.yandexlavka.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.yandexlavka.db.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
