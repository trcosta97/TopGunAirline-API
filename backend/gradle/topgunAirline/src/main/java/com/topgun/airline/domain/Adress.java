package com.topgun.airtravel.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name = "tb_adress")
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
}
