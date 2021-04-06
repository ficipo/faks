package com.faks.faks.service.owner;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.owner.FilterOwnerCommand;
import com.faks.faks.model.command.owner.SaveOwnerCommand;
import com.faks.faks.model.dto.OwnerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;

public interface OwnerService {

    ApiBasePageDTO<OwnerDTO> getAllOwners();

    ApiBaseDTO<OwnerDTO> save(SaveOwnerCommand command);

    Boolean delete(DeleteCommand command);

    ApiBaseDTO<OwnerDTO> filter(FilterOwnerCommand command);
}
