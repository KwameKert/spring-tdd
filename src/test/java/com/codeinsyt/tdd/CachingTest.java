package com.codeinsyt.tdd;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.repository.CarRepository;
import com.codeinsyt.tdd.services.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CachingTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void cashing() throws  Exception{
        given(this.carRepository.findByName(anyString()))
                .willReturn(new Car("honda", "hybrid"));

        this.carService.getCarDetails("honda");
        this.carService.getCarDetails("honda");

        verify(this.carRepository, times(1)).findByName("honda");
    }




}
