package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_flight")
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_flight_date", nullable = false)
    private LocalDate flightDate;
    @Column(name = "nm_origin", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport origin;
    @Column(name = "nm_destination", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport destination;
    @Column(name = "nm_available_seats")
    private Integer availableSeats;
    @Column(name = "bl_active", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public void deactivateFlight(){
        this.active = false;
    }

    public  Flight(FlightDTO data){
        this.flightDate = data.flightDate();
        this.origin = data.origin();
        this.destination= data.destination();
        this.availableSeats = data.availableSeats();
    }
}
