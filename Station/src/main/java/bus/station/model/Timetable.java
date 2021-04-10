package bus.station.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Timetable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int numberOfSeats;
	@Column
	private double ticketPrice;
	@Column
	private String departureTime;
	@Column(nullable = false)
	private String destination;
	@ManyToOne
	private Company company;
	@OneToMany(mappedBy = "timetable", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<>();
	
	public Timetable() {
		super();
	}

	public Timetable(Long id, int numberOfSeats, double ticketPrice, String departureTime, String destination,
			Company company, Set<Reservation> reservations) {
		super();
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.ticketPrice = ticketPrice;
		this.departureTime = departureTime;
		this.destination = destination;
		this.company = company;
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
	
	
	
	

}
