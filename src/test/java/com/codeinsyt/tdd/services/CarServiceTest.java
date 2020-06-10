package com.codeinsyt.tdd.services;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.repository.CarRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws  Exception{
        carService = new CarService(carRepository);

    }

    @Test
    public void getCar_returnCarDetails() throws  Exception{

     given(carRepository.findName("honda")).
             willReturn(new Car("honda", "hybrid"));

     Car car = carService.getCarDetails("honda");

        org.assertj.core.api.Assertions.assertThat(car.getName()).isEqualTo("honda");
        org.assertj.core.api.Assertions.assertThat(car.getType()).isEqualTo("hybrid");

    }

}