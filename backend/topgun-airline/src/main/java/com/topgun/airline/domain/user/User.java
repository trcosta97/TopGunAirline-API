package com.topgun.airline.domain.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.Adress;
import com.topgun.airline.domain.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
    @JoinColumn(name = "cd_adress", nullable = false)
    private Adress adress;
    @Column(name="lg_email", nullable = false, unique = true)
    private String email;
    @Column(name="ps_password")
    private String password;
    @JoinColumn(name = "ls_reservations")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;

    public void deactivateUser(){
        this.active = false;
    }

    public User (UserSaveDTO data){
        this.name = data.name();
        this.adress = data.adress();
        this.email = data.email();
        this.password = data.password();
    }

}
