package program.mapper;

import org.mapstruct.Mapper;
import program.DTO.*;
import program.entities.Address;
import program.entities.Company;
import program.entities.Geo;
import program.entities.User;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    CreateUserDTO userByCreateUserDTO(User user);
    User createUserDTObyUser  (CreateUserDTO createUserDTO);

    AddressDTO addressByAddressDTO(Address address);
    Address addressDTOByAddress (AddressDTO addressDTO);
    CompanyDTO companyByCompanyDTO(Company company);
    Company companyDTOByCompany (CompanyDTO companyDTO);
    GeoDTO geoByGeoDTO(Geo geo);
    Geo geoDTOByGeo (GeoDTO geoDTO);
    List<User> userListByUserDTOList (List<GetUserDTO> userDTOList);
    List<GetUserDTO>userDTOListByUserList (List<User>userList);
}
