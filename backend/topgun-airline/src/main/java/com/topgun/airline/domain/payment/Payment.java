package com.topgun.airline.domain.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_payment")
    private Long id;
    @JoinColumn(name = "id_user", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Column(name = "total_value_payment")
    private BigDecimal value;
    @Column(name = "type_payment")
    private TypeOfPayment typeOfPayment;
    @Column(name = "date_payment")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime payDate;
    @JoinColumn(name = "id_reservation", nullable = false)
    @JsonBackReference
    @OneToOne(mappedBy = "payment")
    private Reservation reservation;
    @Column(name = "payment_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public Payment(PaymentDTO data) {
        this.user = new User(data.userId());
        this.typeOfPayment = data.typeOfPayment();
        this.value = data.value();
    }

    @PrePersist
    protected void prePersist() {
        payDate = LocalDateTime.now();
    }

    public Payment(Long id, User user, BigDecimal value, TypeOfPayment typeOfPayment, LocalDateTime payDate, Boolean active) {
        this.id = id;
        this.user = user;
        this.value = value;
        this.typeOfPayment = typeOfPayment;
        this.payDate = payDate;
        this.active = active;
    }
}
