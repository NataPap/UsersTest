package program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.DTO.CompanyDTO;
import program.entities.Company;
import program.entities.User;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
