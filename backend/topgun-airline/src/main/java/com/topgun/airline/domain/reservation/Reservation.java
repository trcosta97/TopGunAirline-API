package com.topgun.airline.domain.reservation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;



import java.time.LocalDateTime;


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
    @ManyToOne
    private User user;
    @JoinColumn(name = "id_flight")
    @OneToOne
    private Flight flight;
    @Column(name = "available_seats_reservation", nullable = false, precision = 4)
    private Integer numberOfSeats;
    @JoinColumn(name = "id_payment", nullable = false)
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @Column(name="date_reservation")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime reservationDate;
    @Column(name = "active_reservation", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public Reservation(ReservationDTO data) {
        this.user = new User(data.userId());
        this.flight = new Flight(data.flightId());
        this.numberOfSeats = data.numberOfSeats();
        this.payment = new Payment(data.payment());
    }

    public Reservation(ReservationUpdateDTO data){
        this.numberOfSeats = data.numberOfSeats();
    }

    public Reservation(Long reservationId) {
        this.id = reservationId;
    }

    @PrePersist
    protected void prePersist() {
        reservationDate = LocalDateTime.now();
    }


}
