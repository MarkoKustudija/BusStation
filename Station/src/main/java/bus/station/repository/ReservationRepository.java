package bus.station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bus.station.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findOneById(Long id);
	

}
