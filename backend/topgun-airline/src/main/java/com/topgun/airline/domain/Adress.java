package com.topgun.airline.domain;

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
    @Column(name = "cd_adress")
    private Long id;
    @Column(name = "nr_zip_code", nullable = false)
    private String zipCode;
    @Column(name = "nr_number", nullable = false)
    private String number;
    @Column(name = "nm_country", nullable = false)
    private String Country;
    @JsonBackReference
    @OneToOne(mappedBy = "adress")
    @JoinColumn(name = "cd_user", nullable = false)
    private User user;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active;


    public void deactivateAdress(){
        this.active = false;
    }
}
