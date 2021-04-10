package bus.station.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Company;
import bus.station.model.Timetable;
import bus.station.web.dto.CompanyDto;

@Component
public class CompanyToCompanyDto implements Converter<Company, CompanyDto> {
	
	
	
	@Autowired
	private TimetableToTimetableDto toDto;

	@Override
	public CompanyDto convert(Company source) {

		CompanyDto dto = new CompanyDto();
		dto.setId(source.getId());
		dto.setAddress(source.getAddress());
		dto.setName(source.getName());
		dto.setPib(source.getPib());
		
		List<Timetable> timetables = new ArrayList<>(source.getTimetables());
		dto.setTimetables(new HashSet<>(toDto.convert(timetables)));
		return dto;
	}
	
	public List<CompanyDto> convert (List<Company>companies){
		List<CompanyDto>companyDtos = new ArrayList<>();
		for(Company c : companies) {
			companyDtos.add(convert(c));
			
		}
		return companyDtos;
	}
	

}
