package com.dk.keycloak.service;

import com.dk.keycloak.domain.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CarService {
    private List<Car> carList = Stream.of(
            new Car("M5", "Petrol"),
            new Car("Tesla", "Electronic"),
            new Car("Prius", "Hybrid")
    ).collect(Collectors.toList());

    public List<Car> getCarList() {
        return carList;
    }

    public Car saveCar(Car car) {
        carList.add(car);
        return car;
    }
}
