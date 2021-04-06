package com.faks.faks.controller;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.car.FilterCarCommand;
import com.faks.faks.model.command.car.SaveCarCommand;
import com.faks.faks.model.dto.CarDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.service.car.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ApiOperation("List Car")
    @RequestMapping("/all")
    public ApiBasePageDTO<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @ApiOperation("Save Car")
    @RequestMapping("/save")
    public ApiBaseDTO<CarDTO> save(@RequestBody SaveCarCommand command) {
        return carService.save(command);
    }

    @ApiOperation("Update Car")
    @PutMapping("/update")
    public ApiBaseDTO<CarDTO> update(@RequestBody SaveCarCommand command) {
        return carService.save(command);
    }

    @ApiOperation("Delete Car")
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteCommand command) {
        return carService.delete(command);
    }

    @ApiOperation("Filter Car")
    @RequestMapping("/filter")
    public ApiBaseDTO<CarDTO> filter(@RequestBody FilterCarCommand command) {
        return carService.filter(command);
    }


}
