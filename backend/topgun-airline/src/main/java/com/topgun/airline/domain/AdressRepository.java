package com.topgun.airline.domain;

import com.topgun.airline.domain.adress.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByActiveTrue();
}
