package com.faks.faks.model.command.car;

import com.faks.faks.model.entity.Car;
import com.faks.faks.model.entity.Maker;
import com.faks.faks.model.entity.Motor;
import com.faks.faks.model.entity.Owner;
import lombok.Data;

import java.util.Date;

@Data
public class SaveCarCommand {
    private Long id;
    private String modelName;
    private String color;
    private Date manufactureDate;
    private Maker maker;
    private Owner owner;
    private Motor motor;

    public Car toEntity() {
        Car car = new Car();
        car.setId(this.id);
        car.setName(this.modelName);
        car.setColor(this.color);
        car.setManufactureDate(this.manufactureDate);
        car.setMaker(this.maker);
        car.setOwner(this.owner);
        car.setMotor(this.motor);

        return car;
    }
}
