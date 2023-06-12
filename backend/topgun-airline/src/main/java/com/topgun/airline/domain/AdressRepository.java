package com.topgun.airline.domain;

import com.topgun.airline.domain.adress.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Long> {
    List<Adress> findAllByActiveTrue();
}
