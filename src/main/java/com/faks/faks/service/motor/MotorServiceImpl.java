package com.faks.faks.service.motor;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.motor.FilterMotorCommand;
import com.faks.faks.model.command.motor.SaveMotorCommand;
import com.faks.faks.model.dto.MotorDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.dto.base.base.PageDTO;
import com.faks.faks.repository.MotorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class MotorServiceImpl implements MotorService {

    private final MotorRepository motorRepository;

    public MotorServiceImpl(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }

    @Override
    @Transactional
    public ApiBasePageDTO<MotorDTO> getAllMotors() {
        return ApiBasePageDTO.setApiPageResponse(MotorDTO.fromList(motorRepository.findAll()), PageDTO.builder().build());
    }

    @Override
    @Transactional
    public ApiBaseDTO<MotorDTO> save(SaveMotorCommand command) {
        return ApiBaseDTO.generateSuccessResponse(MotorDTO.fromEntity(motorRepository.save(command.toEntity())));
    }

    @Override
    public Boolean delete(DeleteCommand command) {
        motorRepository.deleteById(command.getId());
        return true;
    }

    @Override
    @Transactional
    public ApiBaseDTO<MotorDTO> filter(FilterMotorCommand command) {
        return motorRepository.findById(command.getId())
                .map(motor -> ApiBaseDTO.generateSuccessResponse(MotorDTO.fromEntity(motor)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }
}
