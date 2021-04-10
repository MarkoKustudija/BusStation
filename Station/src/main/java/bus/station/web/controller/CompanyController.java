package bus.station.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bus.station.model.Company;
import bus.station.service.CompanyService;
import bus.station.support.CompanyDtoToCompany;
import bus.station.support.CompanyToCompanyDto;
import bus.station.web.dto.CompanyDto;

@RestController
@RequestMapping(value = "api/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

	@Autowired
	private CompanyService compService;
	@Autowired
	private CompanyToCompanyDto toDto;
	@Autowired
	private CompanyDtoToCompany toCompany;
	
	@GetMapping
	public ResponseEntity <List<CompanyDto>> getAll(){
		List<Company> companies = compService.findAll();
		return new ResponseEntity<>(toDto.convert(companies), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> create (@RequestBody CompanyDto companyDto){
		Company company = toCompany.convert(companyDto);
		Company savedCompany = compService.save(company);
		
		return new ResponseEntity<>(toDto.convert(savedCompany),HttpStatus.CREATED);
		
	}
}
