package com.faks.faks.controller;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.motor.FilterMotorCommand;
import com.faks.faks.model.command.motor.SaveMotorCommand;
import com.faks.faks.model.dto.MotorDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.service.motor.MotorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/motor")
public class MotorController {
    private final MotorService motorService;

    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }

    @ApiOperation("List Motor")
    @RequestMapping("/all")
    public ApiBasePageDTO<MotorDTO> getAllMotors() {
        return motorService.getAllMotors();
    }

    @ApiOperation("Save Motor")
    @RequestMapping("/save")
    public ApiBaseDTO<MotorDTO> save(@RequestBody SaveMotorCommand command) {
        return motorService.save(command);
    }

    @ApiOperation("Update Motor")
    @PutMapping("/update")
    public ApiBaseDTO<MotorDTO> update(@RequestBody SaveMotorCommand command) {
        return motorService.save(command);
    }

    @ApiOperation("Delete Motor")
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteCommand command) {
        return motorService.delete(command);
    }

    @ApiOperation("Filter Motor")
    @RequestMapping("/filter")
    public ApiBaseDTO<MotorDTO> filter(@RequestBody FilterMotorCommand command) {
        return motorService.filter(command);
    }
}
