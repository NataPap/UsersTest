package program.DTO;

import lombok.Data;
import program.entities.Address;



import javax.validation.constraints.Email;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String username;
    @Email(regexp=".+@.+\\..+")
    private String email;
    private Address address;
    private String phone;
    private String website;
}
