package com.codeinsyt.tdd.services;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.exceptions.CarNotFoundException;
import com.codeinsyt.tdd.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws  Exception{
        this.carService = new CarService(this.carRepository);
    }

    @Test
    public void getCar_ReturnCarDetails() throws Exception{
        given(this.carRepository.findByName(anyString()))
                .willReturn(new Car("honda", "hybrid"));

        Car car = this.carService.getCarDetails("honda");
        Assertions.assertThat(car.getName()).isEqualTo("honda");
        Assertions.assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCar_WhenCarNotFound() throws Exception{
        given(this.carRepository.findByName(anyString()))
                .willReturn(null);

        this.carService.getCarDetails("honda");

    }

}