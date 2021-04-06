package com.faks.faks.model.specification;

import com.faks.faks.model.command.motor.FilterMotorCommand;
import com.faks.faks.model.entity.Motor;
import org.springframework.data.jpa.domain.Specification;

public class MotorSpecification {

    private MotorSpecification() {
    }

    public static Specification<Motor> getMotorSpecification(FilterMotorCommand command) {
        SharedSpecification<Motor> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id"))
                .and(sharedSpecification.getLike(command.getName(), "name")));
    }

}
