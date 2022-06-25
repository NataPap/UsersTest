package program.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
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
import program.service.EmailIsValid;

import javax.validation.Valid;
import java.io.IOException;

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
    public List<User> index(){
        return userRepository.findAll();
    }

    @PostMapping( "/addUser")
    public ResponseEntity create(@Valid @RequestBody CreateUserDTO add) throws IOException {

        User user =applicationMapper.createUserDTObyUser(add);
        user.setId(add.getId());
        user.setName(add.getName());
        user.setUsername(add.getUsername());
        user.setEmail(add.getEmail());
        Address address =  applicationMapper.addressDTOByAddress(add.getAddress());
        Geo geo= applicationMapper.geoDTOByGeo(add.getAddress().getGeo());
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

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addAddress")
    public ResponseEntity create(@RequestBody AddressDTO add) throws IOException {

       Address address=new Address();
       address.setStreet(add.getStreet());
       address.setSuite(add.getSuite());
       address.setCity(add.getCity());
       address.setZipcode(add.getZipcode());
       Geo geo= applicationMapper.geoDTOByGeo(add.getGeo());
       geoRepository.save(geo);
       address.setGeo(geoRepository.getReferenceById(geo.getId()));
       addressRepository.save(address);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addCompany")
    public ResponseEntity create(@RequestBody CreateCompanyDTO add) throws IOException {

       Company company=new Company();
       company.setName(add.getName());
       company.setCatchPhrase(add.getCatchPhrase());
       company.setBs(add.getBs());
       companyRepository.save(company);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping( "/addGeo")
    public ResponseEntity create(@RequestBody CreateGeoDTO add) throws IOException {

        Geo geo = new Geo();
        geo.setLat(add.getLat());
        geo.setLng(add.getLng());
        geoRepository.save(geo);


        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping( "/addUsersList")
    public ResponseEntity create( @Valid @RequestBody CreateUsersDTO add) throws IOException {

        for (CreateUserDTO userDto: add.getUserList()) {
            try{
                User user =applicationMapper.createUserDTObyUser(userDto);
                user.setId(userDto.getId());
                user.setName(userDto.getName());
                user.setUsername(userDto.getUsername());
                user.setEmail(userDto.getEmail());
                Address address =  applicationMapper.addressDTOByAddress(userDto.getAddress());
                Geo geo= applicationMapper.geoDTOByGeo(userDto.getAddress().getGeo());
                geoRepository.save(geo);
                address.setGeo(geoRepository.getReferenceById(geo.getId()));
                addressRepository.save(address);
                user.setAddress(address);
                user.setPhone(userDto.getPhone());
                user.setWebsite(userDto.getWebsite());
                Company company = applicationMapper.companyDTOByCompany(userDto.getCompany());
                companyRepository.save(company);
                user.setCompany(company);
                userRepository.save(user);

            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
