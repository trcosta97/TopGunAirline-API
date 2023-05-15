package com.topgun.airline.repository;

import com.topgun.airline.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAtivoTrue();
}
