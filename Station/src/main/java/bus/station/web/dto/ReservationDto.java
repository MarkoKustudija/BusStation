package bus.station.web.dto;



public class ReservationDto {
	
	
	private Long id;
	private Long timetableId;
	
	public ReservationDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimetableId() {
		return timetableId;
	}

	public void setTimetableId(Long timetableId) {
		this.timetableId = timetableId;
	}
	
	
	
	

}
