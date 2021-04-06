package com.faks.faks.model.command.owner;

import lombok.Data;

@Data
public class FilterOwnerCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String oib;
}
