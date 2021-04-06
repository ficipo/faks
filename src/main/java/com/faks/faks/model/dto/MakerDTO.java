package com.faks.faks.model.dto;

import com.faks.faks.model.entity.Maker;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MakerDTO {
    private Long id;
    private String name;
    private String county;

    public static MakerDTO fromEntity(Maker maker) {
        MakerDTO dto = new MakerDTO();
        dto.setId(maker.getId());
        dto.setName(maker.getName());
        dto.setCounty(maker.getCountry());

        return dto;
    }

    public static List<MakerDTO> fromList(List<Maker> makers) {
        return makers.stream().map(MakerDTO::fromEntity).collect(Collectors.toList());
    }
}
