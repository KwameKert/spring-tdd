package com.codeinsyt.tdd.services;

import com.codeinsyt.tdd.domains.Car;
import com.codeinsyt.tdd.exceptions.CarNotFoundException;
import com.codeinsyt.tdd.repository.CarRepository;


public class CarService {

    private CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name){
        Car car = this.carRepository.findByName(name);
        if( car == null){
            throw new CarNotFoundException();
        }
        return car;
    }

}
