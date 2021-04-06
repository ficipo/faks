package com.faks.faks.service.owner;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.owner.FilterOwnerCommand;
import com.faks.faks.model.command.owner.SaveOwnerCommand;
import com.faks.faks.model.dto.OwnerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.model.dto.base.base.ErrorInfo;
import com.faks.faks.model.dto.base.base.PageDTO;
import com.faks.faks.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public ApiBasePageDTO<OwnerDTO> getAllOwners() {
        return ApiBasePageDTO.setApiPageResponse(OwnerDTO.fromList(ownerRepository.findAll()), PageDTO.builder().build());
    }

    @Override
    @Transactional
    public ApiBaseDTO<OwnerDTO> save(SaveOwnerCommand command) {
        return ApiBaseDTO.generateSuccessResponse(OwnerDTO.fromEntity(ownerRepository.save(command.toEntity())));
    }

    @Override
    public Boolean delete(DeleteCommand command) {
        ownerRepository.deleteById(command.getId());
        return true;
    }

    @Override
    @Transactional
    public ApiBaseDTO<OwnerDTO> filter(FilterOwnerCommand command) {
        return ownerRepository.findById(command.getId())
                .map(owner -> ApiBaseDTO.generateSuccessResponse(OwnerDTO.fromEntity(owner)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }
}
