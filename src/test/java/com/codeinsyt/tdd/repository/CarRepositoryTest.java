package com.codeinsyt.tdd.repository;

import com.codeinsyt.tdd.domains.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_ReturnsCar() throws  Exception{
        Car savedCar = this.testEntityManager.persistFlushFind(new Car("honda", "hybrid"));
        Car car = this.carRepository.findByName("honda");

        assertThat(savedCar.getName()).isEqualTo(car.getName());
        assertThat(savedCar.getType()).isEqualTo(car.getType());

    }
}