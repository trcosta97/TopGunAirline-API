package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_flight")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_flight_date", nullable = false)
    private LocalDateTime flightDate;
    @Column(name = "origin_flight", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport origin;
    @Column(name = "destination_flight", nullable = false)
    @Enumerated(EnumType.STRING)
    private Airport destination;
    @Column(name = "available_seats_flight")
    private Integer availableSeats;
    @Column(name = "price_flight")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name = "active_flight", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean active = true;

    public Flight(Long flightId) {
        this.id = flightId;
    }

    public  Flight(FlightDTO data){
        this.flightDate = data.flightDate();
        this.origin = data.origin();
        this.destination= data.destination();
        this.availableSeats = data.availableSeats();
        this.price = data.price();
    }

}
