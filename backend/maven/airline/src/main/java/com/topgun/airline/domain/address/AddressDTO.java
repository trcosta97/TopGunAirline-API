package com.topgun.airline.domain.address;

import com.topgun.airline.domain.user.User;

public record AddressDTO(String zipCode, String number, String country, User user) {
}
