package com.faks.faks.service.maker;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.maker.FilterMakerCommand;
import com.faks.faks.model.command.maker.SaveMakerCommand;
import com.faks.faks.model.dto.MakerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;

public interface MakerService {

    ApiBasePageDTO<MakerDTO> getAllMakers();

    ApiBaseDTO<MakerDTO> save(SaveMakerCommand command);

    Boolean delete(DeleteCommand command);

    ApiBaseDTO<MakerDTO> filter(FilterMakerCommand command);
}
