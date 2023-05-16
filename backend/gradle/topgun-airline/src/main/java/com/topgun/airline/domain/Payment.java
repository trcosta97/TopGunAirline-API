package com.topgun.airtravel.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_payment")
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
