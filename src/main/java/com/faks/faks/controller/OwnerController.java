package com.faks.faks.controller;

import com.faks.faks.model.command.DeleteCommand;
import com.faks.faks.model.command.owner.FilterOwnerCommand;
import com.faks.faks.model.command.owner.SaveOwnerCommand;
import com.faks.faks.model.dto.OwnerDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.service.owner.OwnerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @ApiOperation("List Motor")
    @RequestMapping("/all")
    public ApiBasePageDTO<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @ApiOperation("Save Owner")
    @RequestMapping("/save")
    public ApiBaseDTO<OwnerDTO> save(@RequestBody SaveOwnerCommand command) {
        return ownerService.save(command);
    }

    @ApiOperation("Update Owner")
    @PutMapping("/update")
    public ApiBaseDTO<OwnerDTO> update(@RequestBody SaveOwnerCommand command) {
        return ownerService.save(command);
    }

    @ApiOperation("Delete Owner")
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteCommand command) {
        return ownerService.delete(command);
    }

    @ApiOperation("Filter Owner")
    @RequestMapping("/filter")
    public ApiBaseDTO<OwnerDTO> filter(@RequestBody FilterOwnerCommand command){
        return ownerService.filter(command);
    }
}
