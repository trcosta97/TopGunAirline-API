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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Long id;
    @Column(name = "zip_code_address", nullable = false)
    private String zipCode;
    @Column(name = "number_address", nullable = false)
    private String number;
    @Column(name = "country_address", nullable = false)
    private String country;
    @JsonBackReference
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "id_user")
    private User user;
    @Column(name = "active_address", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active=true;

    public Address(AddressDTO data){
        this.zipCode = data.zipCode();
        this.number = data.number();
        this.country = data.country();
    }

}


