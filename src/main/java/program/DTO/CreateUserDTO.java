package program.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
