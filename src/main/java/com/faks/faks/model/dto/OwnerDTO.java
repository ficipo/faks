package com.faks.faks.model.dto;

import com.faks.faks.model.entity.Owner;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String oib;

    public static OwnerDTO fromEntity(Owner owner) {
        OwnerDTO dto = new OwnerDTO();
        dto.setId(owner.getId());
        dto.setFirstName(owner.getFirstName());
        dto.setLastName(owner.getLastName());
        dto.setOib(owner.getOib());

        return dto;
    }

    public static List<OwnerDTO> fromList(List<Owner> owners) {
        return owners.stream().map(OwnerDTO::fromEntity).collect(Collectors.toList());
    }
}
