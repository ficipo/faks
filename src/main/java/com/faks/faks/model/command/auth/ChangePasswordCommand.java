package com.faks.faks.model.command.auth;

import lombok.Data;

@Data
public class ChangePasswordCommand {
    Long id;
    String email;
    String currentPassword;
    String newPassword;
    String repeatNewPassword;
}
