package com.faks.faks.model.command.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {
    private String email;
    private String password;
}
