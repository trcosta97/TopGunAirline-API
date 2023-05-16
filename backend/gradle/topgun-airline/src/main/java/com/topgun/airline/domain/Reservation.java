package com.topgun.airtravel.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Entity
@Table(name = "tb_reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cd_reservation")
    private Long id;
    @JoinColumn(name = "cd_user")
    @ManyToOne
    private User user;
    @JoinColumn(name = "cd_flight")
    @OneToOne
    private Flight flight;
    @Column(name = "nm_available_seats", nullable = true, precision = 4)
    private Integer numberOfSeats;
    @JoinColumn(name = "cd_payment", nullable = false)
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @Column(name="dt_reservation")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
        private Date reservationDate;

}
