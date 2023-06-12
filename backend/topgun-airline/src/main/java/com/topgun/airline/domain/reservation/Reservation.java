package com.topgun.airline.domain.reservation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_reservation")
    private Long id;
    @JoinColumn(name = "id_user")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @JoinColumn(name = "id_flight")
    @OneToOne
    private Flight flight;
    @Column(name = "reservation_available_seats", nullable = true, precision = 4)
    private Integer numberOfSeats;
    @JoinColumn(name = "id_payment", nullable = false)
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @Column(name="reservation_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime reservationDate;
    @Column(name = "reservation_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public Reservation(ReservationDTO data) {
        this.user = data.user();
        this.flight = data.flight();
        this.numberOfSeats = data.numberOfSeats();
        this.payment = data.payment();
    }

    public Reservation(ReservationUpdateDTO data){
        this.numberOfSeats = data.numberOfSeats();
        this.payment = data.payment();
    }

    public void deactivateReservation(){
        this.active = false;
    }

    @PrePersist
    protected void prePersist() {
        reservationDate = LocalDateTime.now();
    }


}
