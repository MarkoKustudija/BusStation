package bus.station.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bus.station.model.Reservation;
import bus.station.repository.ReservationRepository;
import bus.station.service.ReservationService;

@Service
public class JpaReservationService implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation findOne(Long id) {
		return reservationRepository.findOneById(id);
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}
	

}
