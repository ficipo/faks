package com.faks.faks.model.command.car;

import lombok.Data;

@Data
public class FilterCarCommand {
    private Long id;
    private String name;
    private String owner;

}
