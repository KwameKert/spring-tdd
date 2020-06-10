package com.codeinsyt.tdd;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.services.CarService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @MockBean
    private CarService carService;

    @Test
    public void getCar_returnsCarDetails() throws Exception{
        //arrange

        given(carService.getCarDetails(anyString()))
                .willReturn(new Car("honda", "hybrid"));

        //act
        ResponseEntity<Car> response = this.restTemplate.
                getForEntity("/cars/honda", Car.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("honda");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");


    }

}
