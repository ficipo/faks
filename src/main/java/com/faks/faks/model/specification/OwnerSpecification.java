package com.faks.faks.model.specification;

import com.faks.faks.model.command.owner.FilterOwnerCommand;
import com.faks.faks.model.entity.Owner;
import org.springframework.data.jpa.domain.Specification;

public class OwnerSpecification {

    private OwnerSpecification() {
    }

    public static Specification<Owner> getOwnerSpecification(FilterOwnerCommand command) {
        SharedSpecification<Owner> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id"))
                .and(sharedSpecification.getLike(command.getFirstName(), "firstName"))
                .and(sharedSpecification.getLike(command.getLastName(), "lastName")));
    }

}
