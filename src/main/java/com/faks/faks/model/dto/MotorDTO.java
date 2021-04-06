package com.faks.faks.model.dto;

import com.faks.faks.model.entity.Motor;
import com.faks.faks.model.entity.Type;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MotorDTO {
    private Long id;
    private String name;
    private Integer power;
    private Integer torque;
    private Type type;

    public static MotorDTO fromEntity(Motor motor) {
        MotorDTO dto = new MotorDTO();
        dto.setId(motor.getId());
        dto.setName(motor.getName());
        dto.setPower(motor.getPower());
        dto.setTorque(motor.getTorque());
//        dto.setType(motor.getType());

        return dto;
    }

    public static List<MotorDTO> fromList(List<Motor> motors) {
        return motors.stream().map(MotorDTO::fromEntity).collect(Collectors.toList());
    }
}
