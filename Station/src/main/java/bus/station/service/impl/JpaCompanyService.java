package bus.station.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bus.station.model.Company;
import bus.station.repository.CompanyRepository;
import bus.station.service.CompanyService;

@Service
public class JpaCompanyService  implements CompanyService  {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company findOne(Long id) {
		return companyRepository.findOneById(id);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	
}
