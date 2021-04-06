package com.faks.faks.service.maker;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.maker.FilterMakerCommand;
import com.faks.faks.model.command.maker.SaveMakerCommand;
import com.faks.faks.model.dto.MakerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.dto.base.base.PageDTO;
import com.faks.faks.repository.MakerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MakerServiceImpl implements MakerService {

    private final MakerRepository makerRepository;

    public MakerServiceImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public ApiBasePageDTO<MakerDTO> getAllMakers() {
        return ApiBasePageDTO.setApiPageResponse(MakerDTO.fromList(makerRepository.findAll()), PageDTO.builder().build());
    }

    @Override
    @Transactional
    public ApiBaseDTO<MakerDTO> save(SaveMakerCommand command) {
        return ApiBaseDTO.generateSuccessResponse(MakerDTO.fromEntity(makerRepository.save(command.toEntity())));
    }

    @Override
    public Boolean delete(DeleteCommand command) {
        makerRepository.deleteById(command.getId());
        return true;
    }

    @Override
    @Transactional
    public ApiBaseDTO<MakerDTO> filter(FilterMakerCommand command) {
        return makerRepository.findById(command.getId())
                .map(maker -> ApiBaseDTO.generateSuccessResponse(MakerDTO.fromEntity(maker)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }
}
