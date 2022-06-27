package program.DTO;

import lombok.Data;
import javax.validation.constraints.Email;

@Data
public class CreateUserDTO {
    private int id;
    private String name;
    private String username;
    @Email(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
}
