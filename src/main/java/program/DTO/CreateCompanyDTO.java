package program.DTO;

import lombok.Data;
import program.entities.User;
@Data
public class CreateCompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
}
