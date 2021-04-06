package com.faks.faks.service.car;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.car.FilterCarCommand;
import com.faks.faks.model.command.car.SaveCarCommand;
import com.faks.faks.model.dto.CarDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.dto.base.base.PageDTO;
import com.faks.faks.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public ApiBasePageDTO<CarDTO> getAllCars() {
        return ApiBasePageDTO.setApiPageResponse(CarDTO.fromList(carRepository.findAll()), PageDTO.builder().build());
    }

    @Override
    @Transactional
    public ApiBaseDTO<CarDTO> save(SaveCarCommand command) {
        return ApiBaseDTO.generateSuccessResponse(CarDTO.fromEntity(carRepository.save(command.toEntity())));
    }

    @Override
    public Boolean delete(DeleteCommand command) {
        carRepository.deleteById(command.getId());
        return true;
    }

    @Override
    @Transactional
    public ApiBaseDTO<CarDTO> filter(FilterCarCommand command) {
        return carRepository.findById(command.getId())
                .map(car -> ApiBaseDTO.generateSuccessResponse(CarDTO.fromEntity(car)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }
}
