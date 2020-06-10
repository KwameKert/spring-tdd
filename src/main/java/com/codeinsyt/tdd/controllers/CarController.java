package com.codeinsyt.tdd.controllers;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
