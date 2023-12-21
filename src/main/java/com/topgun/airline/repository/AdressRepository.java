package com.topgun.airline.repository;

import com.topgun.airline.domain.adress.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByActiveTrue();
}
