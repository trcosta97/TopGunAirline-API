package com.topgun.airline.domain.reservation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.user.User;
import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.payment.Payment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;




import java.util.Date;

@Entity
@Table(name = "tb_reservation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
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
