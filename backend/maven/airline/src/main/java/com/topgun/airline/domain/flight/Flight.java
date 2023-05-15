package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.airport.Airport;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "tb_flight")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_flight")
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_flight_date", nullable = false)
    private Date flightDate;
    @Column(name = "nm_origin", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport origin;
    @Column(name = "nm_destination", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport destination;
    @Column(name = "nm_available_seats")
    private Integer availableSeats;
}
