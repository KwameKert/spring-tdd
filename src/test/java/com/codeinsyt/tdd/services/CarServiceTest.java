package com.codeinsyt.tdd.services;

import com.codeinsyt.tdd.CarRepository;
import com.codeinsyt.tdd.domains.Car;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() {
        this.carService = new CarService(this.carRepository);
    }

    @Test
    public void getCarDetails() {
        given(this.carRepository.findByName(anyString()))
                .willReturn(new Car("honda", "hybrid"));


        Car car = this.carService.getCarDetails("honda");

        assertThat(car.getName()).isEqualTo("honda");
        assertThat(car.getType()).isEqualTo("hybrid");

    }
}