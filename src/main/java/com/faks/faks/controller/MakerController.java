package com.faks.faks.controller;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.maker.FilterMakerCommand;
import com.faks.faks.model.command.maker.SaveMakerCommand;
import com.faks.faks.model.dto.MakerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.service.maker.MakerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    private final MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }

    @ApiOperation("List Maker")
    @RequestMapping("/all")
    public ApiBasePageDTO<MakerDTO> getAllMakers() {
        return makerService.getAllMakers();
    }

    @ApiOperation("Save Maker")
    @RequestMapping("/save")
    public ApiBaseDTO<MakerDTO> save(@RequestBody SaveMakerCommand command) {
        return makerService.save(command);
    }

    @ApiOperation("Update Maker")
    @PutMapping("/update")
    public ApiBaseDTO<MakerDTO> update(@RequestBody SaveMakerCommand command) {
        return makerService.save(command);
    }

    @ApiOperation("Delete Maker")
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteCommand command) {
        return makerService.delete(command);
    }

    @ApiOperation("Filter Maker")
    @RequestMapping("/filter")
    public ApiBaseDTO<MakerDTO> filter(@RequestBody FilterMakerCommand command){
        return makerService.filter(command);
    }
}
