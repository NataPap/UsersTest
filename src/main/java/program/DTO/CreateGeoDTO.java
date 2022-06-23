package program.DTO;

import lombok.Data;
import program.entities.Address;

@Data
public class CreateGeoDTO {
    private String lat;
    private String lnd;

}
