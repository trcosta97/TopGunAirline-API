package com.topgun.airline.controller;

import com.topgun.airline.domain.adress.Address;
import com.topgun.airline.domain.adress.AddressDTO;
import com.topgun.airline.domain.user.User;
import com.topgun.airline.domain.user.UserDTO;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<UserDTO> userDTOJson;

    @Autowired
    private JacksonTester<User> userJson;




    @Test
    @DisplayName("Should return http 400 when requires info are null")
    void save_1() throws Exception {
        var response = mvc.perform(MockMvcRequestBuilders.post("/user"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return http 200 when info is valid")
    void save_2() throws Exception {
        var response = mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userDTOJson.write(
                                        new UserDTO("Thiago Ribeiro", new AddressDTO("06872118", "51", "Brazil"), "trcosta97@gmail.com", "abc123")
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var expectedJson = userJson.write(
                new User(1L, "Thiago Ribeiro", new Address(1L, "06872118", "51", "Brazil", true), "trcosta97@gmail.com", "abc123",null, true)
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedJson);
    }


}
