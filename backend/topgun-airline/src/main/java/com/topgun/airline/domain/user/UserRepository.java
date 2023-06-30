package com.topgun.airline.domain.user;

import com.topgun.airline.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByActiveTrue();

    Optional<User> findByEmail(String email);
}
