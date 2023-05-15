package com.topgun.airline.domain.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_payment")
    private Long id;
    @JoinColumn(name = "cd_user", nullable = false)
    private User user;
    @Column(name = "vl_total_value")
    private BigDecimal value;
    @Column(name = "tp_payment_type")
    private TypeOfPayment paymentType;
    @Column(name = "dt_payment_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;
    @JoinColumn(name = "cd_reservation", nullable = false)
    @JsonBackReference
    @OneToOne(mappedBy = "payment")
    private Reservation reservation;
}
