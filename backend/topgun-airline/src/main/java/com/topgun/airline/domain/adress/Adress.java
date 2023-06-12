package com.topgun.airline.domain.adress;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.topgun.airline.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_adress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_adress")
    private Long id;
    @Column(name = "adress_zip_code", nullable = false)
    private String zipCode;
    @Column(name = "adress_number", nullable = false)
    private String number;
    @Column(name = "adress_country", nullable = false)
    private String country;
    @JsonBackReference
    @OneToOne(mappedBy = "adress")
    @JoinColumn(name = "id_user")
    private User user;
    @Column(name = "adress_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;

    public Adress (AdressDTO data){
        this.zipCode = data.zipCode();
        this.number = data.number();
        this.country = data.country();
    }

    public void deactivateAdress() {
        this.active = false;
    }

}


