package com.topgun.airline.domain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import com.topgun.airline.domain.user.User;

@Entity
@Table(name = "tb_adress")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_adress")
    private Long id;
    @Column(name = "nr_zip_code", nullable = false)
    private String zipCode;
    @Column(name = "nr_number", nullable = false)
    private String number;
    @Column(name = "nm_country", nullable = false)
    private String country;
    @JsonBackReference
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "cd_user", nullable = false)
    private User user;
    @Column(name="bl_active")
    private boolean active;

    public Address(Address address) {
        address.zipCode = this.zipCode;
        address.number = this.number;
        address.country = this.country;
        address.user = this.user;
        address.active = this.active;
    }

    public void deactivate(){
        this.active = false;
    }

    public Address(AddressDTO data){

    }
}
