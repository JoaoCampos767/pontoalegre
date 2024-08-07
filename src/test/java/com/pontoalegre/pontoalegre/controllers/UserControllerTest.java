package com.pontoalegre.pontoalegre.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pontoalegre.pontoalegre.dtos.UserRecordDto;
import com.pontoalegre.pontoalegre.models.UserModel;
import com.pontoalegre.pontoalegre.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() throws Exception {
        UserRecordDto userRecordDto = new UserRecordDto("John Doe", "123", "john.doe@example.com", "19989225145");
        UserModel userModel = new UserModel();
        userModel.setName("John Doe");
        userModel.setPassword("123");
        userModel.setEmail("john.doe@example.com");
        userModel.setPhone("19989225145");

        when(userService.saveUser(any(UserRecordDto.class))).thenReturn(userModel);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRecordDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("19989225145"));
    }
}