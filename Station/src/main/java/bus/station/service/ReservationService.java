package bus.station.service;

import java.util.List;

import bus.station.model.Reservation;

public interface ReservationService {
	
	Reservation findOne(Long id);
	List<Reservation> findAll();
	List<Reservation> find(List<Long> idReservations);
	
	

}
