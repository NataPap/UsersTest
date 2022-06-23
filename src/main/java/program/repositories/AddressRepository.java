package program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.DTO.AddressDTO;
import program.entities.Address;
import program.entities.User;


    @Repository
    public interface AddressRepository extends JpaRepository<Address, Integer> {
    }


