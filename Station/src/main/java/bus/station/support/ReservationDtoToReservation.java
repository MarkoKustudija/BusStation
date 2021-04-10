package bus.station.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Reservation;
import bus.station.service.ReservationService;
import bus.station.service.TimetableService;
import bus.station.web.dto.ReservationDto;

@Component
public class ReservationDtoToReservation implements Converter<ReservationDto, Reservation> {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private TimetableService timetableService;

	@Override
	public Reservation convert(ReservationDto source) {
		Reservation reservation = null;
		if(source.getId() == null) {
			reservation = new Reservation();
		} else {
			reservation = reservationService.findOne(source.getId());	
		}
		if(reservation != null) {
			reservation.setId(source.getId());
			reservation.setTimetable(timetableService.findOne(source.getTimetableId()));
		}
		return reservation;
	}
	

}
