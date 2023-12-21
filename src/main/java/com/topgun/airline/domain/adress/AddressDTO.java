package com.topgun.airline.domain.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,
        String number,
        @NotBlank
        String country) {
}
