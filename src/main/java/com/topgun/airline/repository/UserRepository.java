package com.topgun.airline.repository;


import com.topgun.airline.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByActiveTrue();

    User findByEmail(String email);
}
