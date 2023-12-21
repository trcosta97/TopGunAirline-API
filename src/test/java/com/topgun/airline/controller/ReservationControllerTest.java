package com.topgun.airline.controller;

import com.topgun.airline.domain.Airport;
import com.topgun.airline.domain.adress.Address;
import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.payment.PaymentDTO;
import com.topgun.airline.domain.payment.TypeOfPayment;
import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.reservation.ReservationDTO;
import com.topgun.airline.domain.user.User;
import com.topgun.airline.repository.FlightRepository;
import com.topgun.airline.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ReservationControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    JacksonTester<ReservationDTO> reservationDTOJson;

    @Autowired
    JacksonTester<Reservation> reservationJson;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        String dateString = "2023-11-11";
        LocalDateTime date = LocalDateTime.of(2024, 2, 19, 10, 0);
        Integer availableSeats = 500;

        Flight flight = new Flight(1L, date, Airport.TOK, Airport.ROM, availableSeats, true);
        flightRepository.save(flight);

        User user = new User(1L, "Thiago Ribeiro", new Address(1L, "06872118", "51", "Brazil", true), "trcosta97@gmail.com", "abc123",null, true);
        userRepository.save(user);


    }



    @Test
    @DisplayName("Should return http 400 when requires info are null")
    public void save_1() throws Exception {
        var response = mvc.perform(MockMvcRequestBuilders.post("/reservation"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return http 200 when info is valid")
    void save_2() throws Exception {
        String dateString = "2023-11-11";
        LocalDateTime date = LocalDateTime.of(2024, 2, 19, 10, 0);

        var paymentDto = new PaymentDTO(1L, new BigDecimal(3000), TypeOfPayment.CREDIT);

        var reservationDto = new ReservationDTO(1L, 1L, 2, paymentDto);

        var response = mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(reservationDTOJson.write(reservationDto).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var responseJson = response.getContentAsString();
        var responseReservation = reservationJson.parse(responseJson).getObject();
        var payDate = responseReservation.getPayment().getPayDate();
        var reservationDate = responseReservation.getReservationDate();

        var expectedPayment = new Payment(
                1L,
                new User(1L, "Thiago Ribeiro", new Address(1L, "06872118", "51", "Brazil", true), "trcosta97@gmail.com", "abc123",null, true),
                new BigDecimal(3000),
                TypeOfPayment.CREDIT,
                payDate,
                true
        );

        var expectedReservation = new Reservation(1L,
                new User(1L, "Thiago Ribeiro", new Address(1L, "06872118", "51", "Brazil", true), "trcosta97@gmail.com", "abc123",null, true),
                new Flight(1L, date, Airport.ROM, Airport.RIO, 500, true),
                2,
                expectedPayment,
                reservationDate,
                true);

        var expectedJson = reservationJson.write(expectedReservation)
                .getJson();

        assertThat(responseJson).isEqualTo(expectedJson);
    }



    @Test
    @DisplayName("Should return http 200 and all reservations")
    void get_1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/reservation/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @DisplayName("Should return http 200 and user defined by ID")
    void get_2() throws Exception {
        Long reservationId = 1L;

        mvc.perform(MockMvcRequestBuilders.get("/reservation/{id}", reservationId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("return http 200 and reservation by flight defined")
    void get_3() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/reservation/flight")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}






