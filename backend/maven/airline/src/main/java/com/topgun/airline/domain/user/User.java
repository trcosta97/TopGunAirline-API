package com.topgun.airline.domain.user;
import com.topgun.airline.domain.address.Address;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topgun.airline.domain.reservation.Reservation;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
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
    private Address address;
    @Column(name="lg_email", nullable = false, unique = true)
    private String email;
    @Column(name="ps_password")
    private String password;
    @JoinColumn(name = "ls_reservations")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;

    public User(User user) {
        this.name = user.name;
        this.address = user.address;
        this.email = user.email;
        this.password = user.password;
        this.reservations = user.reservations;

    }

    public void deactivate(){
        this.active = false;
    }
}
