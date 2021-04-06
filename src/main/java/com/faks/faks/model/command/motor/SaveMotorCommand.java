package com.faks.faks.model.command.motor;

import com.faks.faks.model.entity.Motor;
import com.faks.faks.model.entity.Type;
import lombok.Data;

@Data
public class SaveMotorCommand {
    private Long id;
    private String name;
    private Integer power;
    private Integer torque;
   // private Type type;
    
    public Motor toEntity() {
        Motor motor = new Motor();
        motor.setId(this.id);
        motor.setName(this.name);
        motor.setPower(this.power);
        motor.setTorque(this.torque);
//        motor.setType(this.type);

        return motor;
    }
}
