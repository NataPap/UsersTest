package program.DTO;

import lombok.Data;
import program.entities.Address;
import program.entities.Company;
@Data
public class CreateUserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
}
