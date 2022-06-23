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
import program.repositories.AddressRepository;
import program.repositories.CompanyRepository;
import program.repositories.GeoRepository;
import program.repositories.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final GeoRepository geoRepository;

    @Autowired
    public UserController(UserRepository userRepository, AddressRepository addressRepository, CompanyRepository companyRepository, GeoRepository geoRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.geoRepository = geoRepository;
    }
    @GetMapping("/")
    public List<User> index(){
        return userRepository.findAll();
    }

    @PostMapping( "/addUser")
    public ResponseEntity create(@RequestBody CreateUserDTO add) throws IOException {

        User user =new User();
        user.setId(add.getId());
        user.setName(add.getName());
        user.setUsername(add.getUsername());
        user.setEmail(add.getEmail());
////        Address address =  addressRepository.getById(add.getId());
//        user.setAddress(add.getAddress());
//        user.setPhone(add.getPhone());
//        user.setWebsite(add.getWebsite());
////        Company company = companyRepository.getById(add.getId());;
//        user.setCompany(add.getCompany());
        userRepository.save(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addAddress")
    public ResponseEntity create(@RequestBody CreateAddressDTO add) throws IOException {

       Address address=new Address();
       address.setStreet(add.getStreet());
       address.setSuite(add.getSuite());
       address.setCity(add.getCity());
       address.setZipcode(add.getZipcode());
//       Geo geo= geoRepository.getReferenceById(add.getGeo().getId());
//       address.setGeo(geo);
       addressRepository.save(address);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addCompany")
    public ResponseEntity create(@RequestBody CreateCompanyDTO add) throws IOException {

       Company company=new Company();
       company.setName(add.getName());
       company.setCatchPhrase(add.getCatchPhrase());
       company.setBs(add.getBs());

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addGeo")
    public ResponseEntity create(@RequestBody CreateGeoDTO add) throws IOException {

        Geo geo = new Geo();
        geo.setLat(add.getLat());
        geo.setLnd(add.getLnd());


        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping( "/addUsersList")
    public ResponseEntity create(@RequestBody CreateUsersDTO add) throws IOException {
    List<CreateUserDTO> users= new ArrayList<>();
        for (CreateUserDTO userDto:users) {
            try{


            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
