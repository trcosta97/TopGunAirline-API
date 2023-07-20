package com.topgun.airline.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topgun.airline.domain.adress.Address;
import com.topgun.airline.domain.adress.AddressDTO;
import com.topgun.airline.domain.user.User;
import com.topgun.airline.domain.user.UserDTO;
import com.topgun.airline.service.UserService;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Mock
    UserService userService;


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
                new User(1L, "Thiago Ribeiro", new Address(1L, "06872118", "51", "Brazil", true), "trcosta97@gmail.com", "abc123", null, true)
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedJson);
    }

    @Test
    @DisplayName("Should return http 200 and all users")
    void get_1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Should return http 200 and user defined by ID")
    void get_2() throws Exception {
        Long userId = 1L;
        mvc.perform(MockMvcRequestBuilders.get("/user/{id}", userId)
                        .param("id", String.valueOf(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    @DisplayName("Should return http 200 and user defined by email")
    void get_3() throws Exception {
        String email = "test@example.com";

        mvc.perform(MockMvcRequestBuilders.get("/user/email")
                        .param("email", email)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Should return http 200")
    public void update() throws Exception {
        Long userId = 1L;
        Address address = new Address(1L, "06872118", "51", "Brazil", true);

        UserDTO userDTO = new UserDTO(
                "John Doe",
                new AddressDTO("06872118", "51", "Guam"),
                "john@example.com",
                "password123"
        );

        User updatedUser = new User(userId, "John Doe", address, "john@example.com","password123",null );

        when(userService.updateUser(any(Long.class), any(User.class))).thenReturn(updatedUser);

        mvc.perform(MockMvcRequestBuilders.put("/user/{id}", userId)
                        .param("id", userId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Should return http 200 after deleting user")
    void delete() throws Exception {
        Long userId = 1L;

        mvc.perform(MockMvcRequestBuilders.delete("/user/{id}", userId)
                        .param("id", userId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}