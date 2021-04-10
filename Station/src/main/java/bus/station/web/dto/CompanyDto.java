package bus.station.web.dto;

import java.util.HashSet;
import java.util.Set;

public class CompanyDto {
	
	
 
	private Long id;
	private String name;
	private String address;
	private String pib;
	private Set<TimetableDto> timetables = new HashSet<>();
	
	
	
	public CompanyDto() {
		super();
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPib() {
		return pib;
	}



	public void setPib(String pib) {
		this.pib = pib;
	}



	public Set<TimetableDto> getTimetables() {
		return timetables;
	}



	public void setTimetables(Set<TimetableDto> timetables) {
		this.timetables = timetables;
	}
	
	
	
	
	
	

}
