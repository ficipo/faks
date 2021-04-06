package com.faks.faks.model.specification;

import com.faks.faks.model.command.maker.FilterMakerCommand;
import com.faks.faks.model.entity.Maker;
import org.springframework.data.jpa.domain.Specification;

public class MakerSpecification {

    private MakerSpecification() {
    }

    public static Specification<Maker> getMakerSpecification(FilterMakerCommand command) {
        SharedSpecification<Maker> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id"))
                .and(sharedSpecification.getLike(command.getName(), "name")));
    }

}
