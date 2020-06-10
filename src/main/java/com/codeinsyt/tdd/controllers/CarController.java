package com.codeinsyt.tdd.controllers;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.exceptions.CarNotFoundException;
import com.codeinsyt.tdd.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    public Car getCar(@PathVariable String name){
        return this.carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundExceptions(CarNotFoundException exp){

    }
}
