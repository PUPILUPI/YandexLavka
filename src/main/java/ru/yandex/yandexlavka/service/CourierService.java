package ru.yandex.yandexlavka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.repository.CourierRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository repository;
    public Collection<Courier> createCouriers(final Collection<Courier> couriers) {
        return repository.saveAll(couriers);
    }

    public Collection<Courier> getCouriers(final int limit, final int offset) {
        return repository.getCouriers(limit, offset);
    }
    public Optional<Courier> getCourier(final long id) {
        return repository.findById(id);
    }


}
