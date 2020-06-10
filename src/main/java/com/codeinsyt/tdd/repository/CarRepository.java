package com.codeinsyt.tdd.repository;

import com.codeinsyt.tdd.domains.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository  extends CrudRepository<Car, Long> {

    Car findByName(String name);
}
