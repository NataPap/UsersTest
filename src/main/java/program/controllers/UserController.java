package program.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.DTO.*;
import program.entities.Address;
import program.entities.Company;
import program.entities.Geo;
import program.entities.User;
import program.mapper.ApplicationMapper;
import program.repositories.AddressRepository;
import program.repositories.CompanyRepository;
import program.repositories.GeoRepository;
import program.repositories.UserRepository;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping


public class UserController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final GeoRepository geoRepository;
    private final ApplicationMapper applicationMapper;

    @Autowired
    public UserController(UserRepository userRepository, AddressRepository addressRepository, CompanyRepository companyRepository,
                          GeoRepository geoRepository, ApplicationMapper applicationMapper) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.geoRepository = geoRepository;
        this.applicationMapper = applicationMapper;
    }
    @GetMapping("/")
    public List<GetUserDTO> index() {
        return  applicationMapper
                .userDTOListByUserList(userRepository.findAll());
    }

    @PostMapping( "/addUser")
    public ResponseEntity create(@Valid @RequestBody CreateUserDTO add) {
        try {
            User user = applicationMapper.createUserDTObyUser(add);
            if (userRepository.existsById(add.getId())) {
                throw new RuntimeException("User with this ID = " + add.getId() + " already exists");
            } else {
                user.setId(add.getId());
                user.setName(add.getName());
                user.setUsername(add.getUsername());
                user.setEmail(add.getEmail());
                Address address = applicationMapper.addressDTOByAddress(add.getAddress());
                address.setId(user.getId());
                Geo geo = applicationMapper.geoDTOByGeo(add.getAddress().getGeo());
                geo.setId(user.getId());
                geoRepository.save(geo);
                address.setGeo(geoRepository.getReferenceById(geo.getId()));
                addressRepository.save(address);
                user.setAddress(address);
                user.setPhone(add.getPhone());
                user.setWebsite(add.getWebsite());
                Company company = applicationMapper.companyDTOByCompany(add.getCompany());
                companyRepository.save(company);
                user.setCompany(company);
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addUsersList")
    public ResponseEntity create( @Valid @RequestBody CreateUsersDTO add) {

        for (CreateUserDTO userDto: add.getUserList()) {
            try{
                User user =applicationMapper.createUserDTObyUser(userDto);

                if(userRepository.existsById(userDto.getId())) {
                    throw new RuntimeException("User with this ID = "+userDto.getId()+ " already exists");
                } else {
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    user.setUsername(userDto.getUsername());
                    user.setEmail(userDto.getEmail());
                    Address address = applicationMapper.addressDTOByAddress(userDto.getAddress());
                    address.setId(user.getId());
                    Geo geo = applicationMapper.geoDTOByGeo(userDto.getAddress().getGeo());
                    geo.setId(user.getId());
                    geoRepository.save(geo);
                    address.setGeo(geoRepository.getReferenceById(geo.getId()));
                    addressRepository.save(address);
                    user.setAddress(address);
                    user.setPhone(userDto.getPhone());
                    user.setWebsite(userDto.getWebsite());
                    Company company = applicationMapper.companyDTOByCompany(userDto.getCompany());
                    company.setId(user.getId());
                    companyRepository.save(company);
                    user.setCompany(company);
                    userRepository.save(user);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
