package com.dk.keycloak.controller;

import com.dk.keycloak.domain.Car;
import com.dk.keycloak.service.CarService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/cars/list")
    public List<Car> list() {
        List<Car> carList = carService.getCarList();
        return carList;
    }

    @RequestMapping("cars/save")
    public List<Car> saveCar(@RequestBody Car car) {
        Car saved = carService.saveCar(car);
        return carService.getCarList();
    }
}
