package bus.station.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Timetable timetable;
	
	
	public Reservation() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Timetable getTimetable() {
		return timetable;
	}


	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	
	
	
	

}
