package com.codeinsyt.tdd.services;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.exceptions.CarNotFoundException;
import com.codeinsyt.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;


public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name){
        Car car = this.carRepository.findName(name);
        if( car == null){
            throw new CarNotFoundException();
        }
        return car;
    }
}
