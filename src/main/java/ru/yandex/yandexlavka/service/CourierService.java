package ru.yandex.yandexlavka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.db.entity.Courier;
import ru.yandex.yandexlavka.db.repository.CourierRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository repository;
    public Collection<Courier> createCouriers(final Collection<Courier> couriers) {
        return repository.saveAll(couriers);
    }


}
