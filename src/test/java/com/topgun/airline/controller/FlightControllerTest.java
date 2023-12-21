package com.topgun.airline.controller;


import com.topgun.airline.domain.Airport;
import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.flight.FlightDTO;


import com.topgun.airline.service.FlightService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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


import java.time.LocalDateTime;

import static com.topgun.airline.controller.UserControllerTest.asJsonString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class FlightControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    JacksonTester<Flight> flightJson;
    @Autowired
    JacksonTester<FlightDTO> flightDTOJson;
    @Mock
    FlightService flightService;


    @Test
    @DisplayName("Should return http 400 when requires info are null")
    public void save_1() throws Exception {
        var response = mvc.perform(MockMvcRequestBuilders.post("/flight"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return http 200 when info is valid")
    void save_2() throws Exception {
        LocalDateTime date = LocalDateTime.of(2024, 2, 19, 10, 0);

        var response = mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/flight")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(flightDTOJson.write(
                                        new FlightDTO(date, Airport.PAR, Airport.NYC, 500)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var expectedJson = flightJson.write(
                new Flight(1L, date, Airport.TOK, Airport.TOK, 500, true)
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedJson);
    }

    @Test
    @DisplayName("Should return 200 and return header 'Ordered by: Flight date'")
    void get_1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/flight/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Ordered by: ", "Flight date"));
    }

    @Test
    @DisplayName("Should return 200 and return header 'Ordered by: Flight destination'")
    void get_2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/flight/destination")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Ordered by: ", "Flight destination"));
    }

    @Test
    @DisplayName("Should return 200 and return header 'Ordered by: Flight origin'")
    void get_3() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/flight/origin")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Ordered by: ", "Flight origin"));
    }

    @Test
    @DisplayName("Should return 200 and return header 'Ordered by: Flight origin'")
    void get_4() throws Exception {
        Long flightId = 1L;

        mvc.perform(MockMvcRequestBuilders.get("/flight/{id}", flightId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return http 200")
    public void update() throws Exception {
        Long flightId = 1L;
        LocalDateTime date = LocalDateTime.of(2024, 2, 19, 10, 0);

        FlightDTO flightDTO = new FlightDTO(
                date,
                Airport.PAR,
                Airport.ROM,
                500
        );

        Flight updatedFlight = new Flight(flightId, date, Airport.NYC, Airport.ROM, 500, null);

        when(flightService.updateFlight(any(Long.class), any(Flight.class))).thenReturn(updatedFlight);

        mvc.perform(MockMvcRequestBuilders.put("/flight/{id}", flightId)
                        .param("id", flightId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(flightDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}