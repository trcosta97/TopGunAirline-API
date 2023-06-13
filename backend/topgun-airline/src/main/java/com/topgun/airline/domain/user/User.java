package com.topgun.airline.domain.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.adress.Adress;
import com.topgun.airline.domain.reservation.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "User")
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_user")
    private Long id;
    @Column(name = "nm_user", nullable = false, length = 70)
    private String name;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_adress")
    private Adress adress;
    @Column(name="lg_email", nullable = false, unique = true)
    private String email;
    @Column(name="ps_password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Reservation> reservations;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public User(Long userId) {
        this.id = userId;
    }

    public void deactivateUser(){
        this.active = false;
    }

    public User(UserDTO data) {
        this.name = (data.name() != null) ? data.name() : this.name;
        this.adress = (data.adress() != null) ? new Adress(data.adress()) : this.adress;
        this.email = (data.email() != null) ? data.email() : this.email;
        this.password = (data.password() != null) ? data.password() : this.password;
    }


}
