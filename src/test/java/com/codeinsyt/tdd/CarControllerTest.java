package com.codeinsyt.tdd;

import com.codeinsyt.tdd.controllers.CarController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCar_shouldReturnCar () throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cars/honda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("honda"))
                .andExpect(jsonPath("type").value("hybrid"));

    }
}
