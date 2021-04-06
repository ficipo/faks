package com.faks.faks.controller;

import com.faks.faks.model.command.auth.LoginCommand;
import com.faks.faks.model.dto.auth.LoginDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.service.auth.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "Authenticates user")
    @PostMapping("login")
    public ApiBaseDTO<LoginDTO> loginUser(@RequestBody LoginCommand command, HttpServletRequest request) {
        return authService.loginUser(command, request);
    }

    @GetMapping("logout")
    @ApiOperation(value = "Logout user from tenant portal")
    public Boolean logoutUser() {
        return authService.logoutUser();
    }

    @GetMapping("logged-user-data")
    @ApiOperation(value = "Get data from currently logged in user")
    public LoginDTO getLoggedUserData() {
        return authService.getLoggedUserData();
    }

//    @PostMapping("change-password")
//    @ApiOperation(value = "Change users password")
//    public Boolean changePassword(@RequestBody ChangePasswordCommand command) {
//        return authService.changePassword(command);
//    }

}
