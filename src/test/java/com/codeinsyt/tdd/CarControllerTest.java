package com.codeinsyt.tdd;

import com.codeinsyt.tdd.controllers.CarController;
import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.exceptions.CarNotFoundException;
import com.codeinsyt.tdd.services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_shouldReturnCar () throws Exception{
        given(carService.getCarDetails(anyString())).
                willReturn(new Car("honda", "hybrid"));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/cars/honda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("honda"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_shouldReturnCarNotFound() throws Exception{
        given(carService.getCarDetails(anyString()))
                .willThrow(new CarNotFoundException());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/cars/honda"))
                .andExpect(status().isNotFound());
    }
}
