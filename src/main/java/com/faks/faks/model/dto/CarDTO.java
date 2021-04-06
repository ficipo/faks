package com.faks.faks.model.dto;

import com.faks.faks.model.entity.Car;
import com.faks.faks.model.entity.Maker;
import com.faks.faks.model.entity.Motor;
import com.faks.faks.model.entity.Owner;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CarDTO {
    private Long id;
    private String name;
    private String color;
    private Date manufactureDate;
    private Maker maker;
    private Owner owner;
    private Motor motor;

    public static CarDTO fromEntity(Car car) {
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setName(car.getName());
        dto.setColor(car.getColor());
        dto.setManufactureDate(car.getManufactureDate());
        dto.setMaker(car.getMaker());
        dto.setOwner(car.getOwner());
        dto.setMotor(car.getMotor());

        return dto;
    }

    public static List<CarDTO> fromList(List<Car> cars) {
        return cars.stream().map(CarDTO::fromEntity).collect(Collectors.toList());
    }
}
