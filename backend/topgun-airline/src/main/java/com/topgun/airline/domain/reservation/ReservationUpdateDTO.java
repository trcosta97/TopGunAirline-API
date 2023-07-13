package com.topgun.airline.domain.reservation;

import jakarta.validation.constraints.NotNull;

public record ReservationUpdateDTO(
        @NotNull
        Integer numberOfSeats) {
}
