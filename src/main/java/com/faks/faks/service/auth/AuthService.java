package com.faks.faks.service.auth;

import com.faks.faks.model.command.auth.LoginCommand;
import com.faks.faks.model.dto.auth.LoginDTO;
import com.faks.faks.model.dto.base.base.ApiBaseDTO;
import com.faks.faks.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    ApiBaseDTO<LoginDTO> loginUser(LoginCommand loginCommand, HttpServletRequest request);

    LoginDTO getLoggedUserData();

    Boolean logoutUser();

    User getUserFromPrincipal();

}
