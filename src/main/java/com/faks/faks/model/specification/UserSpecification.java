package com.faks.faks.model.specification;

import com.faks.faks.model.command.user.FilterUserCommand;
import com.faks.faks.model.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    private UserSpecification() {
    }

    public static Specification<User> getUserSpecification(FilterUserCommand command) {
        SharedSpecification<User> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id")));
    }
}
