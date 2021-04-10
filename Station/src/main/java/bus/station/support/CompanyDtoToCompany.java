package bus.station.support;


import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Company;
import bus.station.model.Timetable;
import bus.station.service.CompanyService;
import bus.station.service.TimetableService;
import bus.station.web.dto.CompanyDto;
import bus.station.web.dto.TimetableDto;

@Component
public class CompanyDtoToCompany implements Converter<CompanyDto, Company>{
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private TimetableService timetableService;

	@Override
	public Company convert(CompanyDto source) {
		Company company = null;
		if(source.getId() == null) {
			company = new Company();
		} else {
			company = companyService.findOne(source.getId());
		}
		if(company != null) {
			company.setId(source.getId());
			company.setAddress(source.getAddress());
			company.setName(source.getName());
			company.setPib(source.getPib());
			
			List<Long> idTimetables = source.getTimetables().stream().map(TimetableDto::getId).collect(Collectors.toList());
			List<Timetable> timetables = timetableService.find(idTimetables);
			company.setTimetables(new HashSet<>(timetables));
		    
		}
		return company;
	}
	

}
