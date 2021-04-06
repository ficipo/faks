package com.faks.faks.service.motor;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.motor.FilterMotorCommand;
import com.faks.faks.model.command.motor.SaveMotorCommand;
import com.faks.faks.model.dto.MotorDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;

public interface MotorService {

    ApiBasePageDTO<MotorDTO> getAllMotors();

    ApiBaseDTO<MotorDTO> save(SaveMotorCommand command);

    Boolean delete(DeleteCommand command);

    ApiBaseDTO<MotorDTO> filter(FilterMotorCommand command);
}
