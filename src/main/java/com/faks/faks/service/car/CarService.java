package com.faks.faks.service.car;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.car.FilterCarCommand;
import com.faks.faks.model.command.car.SaveCarCommand;
import com.faks.faks.model.dto.CarDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;

public interface CarService {

    ApiBasePageDTO<CarDTO> getAllCars();

    ApiBaseDTO<CarDTO> save(SaveCarCommand command);

    Boolean delete(DeleteCommand command);

    ApiBaseDTO<CarDTO> filter(FilterCarCommand command);

}
