package com.topgun.airline.service;



import com.topgun.airline.domain.user.User;
import com.topgun.airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveUser(User newUser){

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public User findUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return userRepository.findAllByActiveTrue();
    }

    public User updateUser(Long id, User inputUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            if (inputUser.getReservations() != null) {
                existingUser.setReservations(inputUser.getReservations());
            }
            if (inputUser.getName() != null) {
                existingUser.setName(inputUser.getName());
            }
            if (inputUser.getPassword() != null) {
                existingUser.setPassword(inputUser.getPassword());
            }
            if (inputUser.getAddress() != null) {
                existingUser.setAddress(inputUser.getAddress());
            }
            if (inputUser.getEmail() != null) {
                existingUser.setEmail(inputUser.getEmail());
            }

            userRepository.save(existingUser);
            return existingUser;
        }
        return null;
    }


    public User deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setActive(false);
            userRepository.save(user);
            return user;
        }
        return null;
    }


}

