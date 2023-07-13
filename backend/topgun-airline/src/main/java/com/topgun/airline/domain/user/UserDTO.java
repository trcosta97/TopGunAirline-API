package com.topgun.airline.domain.user;

import com.topgun.airline.domain.adress.AddressDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotBlank
        String name,
        @NotNull
        AddressDTO adress,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password) {
}
