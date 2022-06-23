package program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.DTO.GeoDTO;
import program.entities.Company;
import program.entities.Geo;

@Repository
public interface GeoRepository extends JpaRepository<Geo, Integer> {
}
