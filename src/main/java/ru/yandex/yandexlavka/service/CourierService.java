package ru.yandex.yandexlavka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.entity.CourierMetaInfo;
import ru.yandex.yandexlavka.db.repository.CourierRepository;
import ru.yandex.yandexlavka.db.repository.OrderRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository repository;
    private final OrderRepository orderRepository;

    public Collection<Courier> createCouriers(final Collection<Courier> couriers) {
        return repository.saveAll(couriers);
    }

    public Collection<Courier> getCouriers(final int limit, final int offset) {
        return repository.getCouriers(limit, offset);
    }

    public Optional<Courier> getCourier(final long id) {
        return repository.findById(id);
    }

    public CourierMetaInfo calculateMetaInfo(Courier courier,
                                             LocalDateTime startDate,
                                             LocalDateTime endDate) {
        int orderCount = orderRepository.countByCourierAndCompletedTimeBetween(courier, startDate, endDate);
        if (orderCount == 0) {
            return new CourierMetaInfo(null, null);
        }
        long hoursCount = Duration.between(startDate, endDate).toHours();
        int rating = (int) Math.round((double)orderCount / hoursCount) * courier.getType().getRatingCoefficient();
        int earnings = orderRepository.calculateEarnings(courier, courier.getType().getEarningsCoefficient(), startDate, endDate);
        return new CourierMetaInfo(rating, earnings);
    }

}
