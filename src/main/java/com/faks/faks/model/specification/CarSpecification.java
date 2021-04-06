package com.faks.faks.model.specification;

import com.faks.faks.model.command.car.FilterCarCommand;
import com.faks.faks.model.entity.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification {

    private CarSpecification() {
    }

    public static Specification<Car> getCarSpecification(FilterCarCommand command) {
        SharedSpecification<Car> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id"))
                .and(sharedSpecification.getLike(command.getName(), "title")));
    }

}
