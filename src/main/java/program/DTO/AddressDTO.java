package program.DTO;

import lombok.Data;
import program.entities.Geo;
import program.entities.User;
@Data
public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

}
