package com.faks.faks.controller;

import com.faks.faks.model.command.user.DeleteUserCommand;
import com.faks.faks.model.command.user.FilterUserCommand;
import com.faks.faks.model.command.user.SaveUserCommand;
import com.faks.faks.model.dto.auth.UserDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.dto.base.base.ApiBasePageDTO;
import com.faks.faks.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("List User")
    @RequestMapping("/all")
    public ApiBasePageDTO<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation("Save User")
    @RequestMapping("/save")
    public ApiBaseDTO<UserDTO> saveUser(@RequestBody SaveUserCommand command) {
        return userService.saveUser(command);
    }

    @ApiOperation("Update User")
    @PutMapping("/update")
    public ApiBaseDTO<UserDTO> update(@RequestBody SaveUserCommand command) {
        return userService.saveUser(command);
    }

    @ApiOperation("Filter Users")
    @RequestMapping("/filter")
    public ApiBaseDTO<UserDTO> filterUsers(@RequestBody FilterUserCommand command) {
        return userService.filterUser(command);
    }

    @ApiOperation("Delete User")
    @RequestMapping("/delete")
    public Boolean deleteUser(@RequestBody DeleteUserCommand command) {
        return userService.deleteUser(command);
    }
}
