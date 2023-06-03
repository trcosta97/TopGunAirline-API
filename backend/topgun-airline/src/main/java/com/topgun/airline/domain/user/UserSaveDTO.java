package com.topgun.airline.domain.user;

import com.topgun.airline.domain.Adress;

public record UserSaveDTO(String name, Adress adress, String email, String password) {
}
