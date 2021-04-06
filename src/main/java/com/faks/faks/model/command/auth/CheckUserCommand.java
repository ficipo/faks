package com.faks.faks.model.command.auth;

import lombok.Data;

@Data
public class CheckUserCommand {
    private String refreshToken;
    private String email;
    private Long tenantId;
    private String domain;
}
