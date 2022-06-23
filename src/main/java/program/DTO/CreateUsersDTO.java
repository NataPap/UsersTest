package program.DTO;

import lombok.Data;
import program.entities.User;

import java.util.List;
@Data
public class CreateUsersDTO {
    List<User> userList;
}
