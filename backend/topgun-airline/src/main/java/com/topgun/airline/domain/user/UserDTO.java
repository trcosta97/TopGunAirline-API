package com.topgun.airline.domain.user;

import com.topgun.airline.domain.adress.AdressDTO;

public record UserDTO(String name, AdressDTO adress, String email, String password) {
}
