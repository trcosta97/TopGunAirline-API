package com.topgun.airline.domain.user;

import com.topgun.airline.domain.adress.AddressDTO;

public record UserDTO(String name, AddressDTO adress, String email, String password) {
}
