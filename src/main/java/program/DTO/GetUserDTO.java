package program.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
@Data
public class GetUserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
}
