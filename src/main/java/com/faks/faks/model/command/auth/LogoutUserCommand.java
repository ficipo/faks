package com.faks.faks.model.command.auth;

import lombok.Data;

@Data
public class LogoutUserCommand {
    private String username;
    private String jwtToken;
}
