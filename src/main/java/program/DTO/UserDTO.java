package program.DTO;

import lombok.Data;
import program.entities.Address;
import program.entities.Company;
@Data
public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
}
