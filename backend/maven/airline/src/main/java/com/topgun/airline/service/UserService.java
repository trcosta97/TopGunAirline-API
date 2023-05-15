package com.topgun.airline.service;

import com.topgun.airline.domain.user.User;
import com.topgun.airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    public User findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return new User(optionalUser.get());
        }
        return null;
    }

    public List<User> allUsers(){
        List<User> users = userRepository.findAllByAtivoTrue();
        return users;
    }

    public User updateUser(User newUser, Long id){
        Optional<User> optionalUser = userRepository.findById(id);{
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                user.setName(newUser.getName());
                user.setAddress(newUser.getAddress());
                user.setEmail(newUser.getEmail());
                user.setPassword(newUser.getPassword());
                user.setReservations(newUser.getReservations());
                userRepository.save(newUser);
                return user;
            }
            return null;
        }
    }

    public User deactivateUser(Long id){
       Optional<User> optionalUser = userRepository.findById(id);
       if(optionalUser.isPresent()){
           User user = optionalUser.get();
           user.deactivate();
           return user;
       }
       return null;

    }


}
