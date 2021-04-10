package bus.station.service;

import java.util.List;

import bus.station.model.Company;

public interface CompanyService {
	
	Company findOne(Long id);
	List<Company> findAll();
	Company save(Company company);

}
