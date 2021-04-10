package bus.station.web.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class TimetableDto {
	
	
	private Long id;
	@Positive
	private int numberOfSeats;
	private double ticketPrice;
	private String departureTime;
	@NotBlank
	private String destination;
	private Long companyId;
	private Set<ReservationDto> reservations = new HashSet<>();
	
	public TimetableDto() {
		super();
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Set<ReservationDto> getReservations() {
		return reservations;
	}

	public void setReservations(Set<ReservationDto> reservations) {
		this.reservations = reservations;
	}
	
	
	
	

}
