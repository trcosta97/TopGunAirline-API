package com.topgun.airline.service;

import com.topgun.airline.domain.User;
import com.topgun.airline.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public User saveUser(User newUser){
        return userRepository.save(newUser);
    }

    public User findUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public List<User> findAllUsers(){
        return userRepository.findAllByActiveTrue();
    }

    public User updateUser(Long id, User inputUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User updatedUser = optionalUser.get();
            updatedUser.setReservations(inputUser.getReservations());
            updatedUser.setName(inputUser.getName());
            updatedUser.setPassword(inputUser.getPassword());
            updatedUser.setAdress(inputUser.getAdress());
            updatedUser.setEmail(inputUser.getEmail());
            userRepository.save(inputUser);
            return updatedUser;
        }
        return null;
    }

    public User deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.save(user);
            return user;
        }
        return null;
    }


}

