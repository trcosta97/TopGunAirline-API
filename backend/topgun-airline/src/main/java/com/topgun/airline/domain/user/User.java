package com.topgun.airline.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.adress.Address;
import com.topgun.airline.domain.reservation.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;
    @Column(name = "name_user", nullable = false, length = 70)
    private String name;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    @Column(name="email_email", nullable = false, unique = true)
    private String email;
    @Column(name="ps_password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Reservation> reservations;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public User(Long userId) {
        this.id = userId;
    }

    public User(UserDTO data) {
        this.name = (data.name() != null) ? data.name() : this.name;
        this.address = (data.adress() != null) ? new Address(data.adress()) : this.address;
        this.email = (data.email() != null) ? data.email() : this.email;
        this.password = (data.password() != null) ? data.password() : this.password;
    }

    public User(Long id, String name, Address address, String email, String password, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.reservations = reservations;
    }
}
