package ru.yandex.yandexlavka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.yandexlavka.db.entity.Address;
import ru.yandex.yandexlavka.db.repository.AddressRepository;

@RestController
@RequestMapping("/api")
public class AddressController {
  private final AddressRepository addressRepository;
  public AddressController(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }
  @GetMapping("/addresses")
  public List<Address> getAddresses() {
    return addressRepository.findAll();
  }


}
