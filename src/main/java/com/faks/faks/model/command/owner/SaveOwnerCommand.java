package com.faks.faks.model.command.owner;

import com.faks.faks.model.entity.Owner;
import lombok.Data;

@Data
public class SaveOwnerCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String oib;

    public Owner toEntity() {
        Owner owner = new Owner();
        owner.setId(this.id);
        owner.setFirstName(this.firstName);
        owner.setLastName(this.lastName);
        owner.setOib(this.oib);

        return owner;
    }
}
