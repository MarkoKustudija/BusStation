package bus.station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bus.station.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	Company findOneById(Long id);

}
