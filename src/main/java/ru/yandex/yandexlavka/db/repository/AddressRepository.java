package ru.yandex.yandexlavka.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.yandexlavka.db.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressById(Integer id);

//    @Query("from UserInfo u where u.name=:name")
//    UserInfo findUser(@Param("name") String name);

}