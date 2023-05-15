package com.topgun.airtravel.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "tb_usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_user")
    private Long id;
    @Column(name = "nm_user", nullable = false, length = 70)
    private String name;
    @JoinColumn(name="cd_adress", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Adress adress;
    @Column(name="lg_email", nullable = false, unique = true)
    private String email;
    @Column(name="ps_password")
    private String password;
    @JoinColumn(name = "ls_reservations")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;

}
