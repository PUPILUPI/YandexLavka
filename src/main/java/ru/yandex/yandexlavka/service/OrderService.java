package ru.yandex.yandexlavka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.entity.Order;
import ru.yandex.yandexlavka.db.repository.OrderRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    public Optional<Order> getOrderById(final long id) {
        return repository.findById(id);
    }

    public Collection<Order> saveOrders(Collection<Order> orders) {
       return repository.saveAll(orders);
    }

    public Collection<Order> getOrders(final int limit, final int offset) {
        return repository.getOrders(limit, offset);
    }

    public Collection<Order> getOrders(Collection<Long> ids) {
        return repository.findAllById(ids);
    }
    public Collection<Order> updateCompleteTime(Collection<Order> orders) {
        return repository.saveAll(orders);
    }
}
