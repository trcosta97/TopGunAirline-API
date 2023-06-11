package com.topgun.airline.domain.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.topgun.airline.domain.Reservation;
import com.topgun.airline.domain.TypeOfPayment;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_payment")
    private Long id;
    @JoinColumn(name = "cd_user", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Column(name = "vl_total_value")
    private BigDecimal value;
    @Column(name = "tp_payment_type")
    private TypeOfPayment typeOfPayment;
    @Column(name = "dt_payment_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;
    @JoinColumn(name = "cd_reservation", nullable = false)
    @JsonBackReference
    @OneToOne(mappedBy = "payment")
    private Reservation reservation;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;

    public Payment(PaymentDTO data) {
        this.user = data.user();
        this.typeOfPayment = data.typeOfPayment();
        this.reservation = data.reservation();
        this.value = data.value();
    }

    public void deactivatePayment(){
        this.active = false;
    }
}
