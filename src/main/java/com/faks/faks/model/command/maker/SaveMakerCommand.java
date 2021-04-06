package com.faks.faks.model.command.maker;

import com.faks.faks.model.entity.Maker;
import lombok.Data;

@Data
public class SaveMakerCommand {
    private Long id;
    private String name;
    private String country;

    public Maker toEntity() {
        Maker maker = new Maker();
        maker.setId(this.id);
        maker.setName(this.name);
        maker.setCountry(this.country);

        return maker;
    }
}
