package bus.station.support;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Reservation;
import bus.station.model.Timetable;
import bus.station.service.CompanyService;
import bus.station.service.ReservationService;
import bus.station.service.TimetableService;
import bus.station.web.dto.ReservationDto;
import bus.station.web.dto.TimetableDto;

@Component
public class TimetableDtoToTimetable implements Converter<TimetableDto, Timetable> {
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ReservationService reservationService;

	@Override
	public Timetable convert(TimetableDto source) {
		Timetable timetable = null;
		
		if(source.getId() == null) {
			timetable = new Timetable();
		} else {
		timetable = timetableService.findOne(source.getId());
		} 
		if(timetable != null) {
			timetable.setId(source.getId());
			timetable.setNumberOfSeats(source.getNumberOfSeats());
			timetable.setDepartureTime(source.getDepartureTime());
			timetable.setTicketPrice(source.getTicketPrice());
			timetable.setDestination(source.getDestination());
			timetable.setCompany(companyService.findOne(source.getCompanyId()));
			
			List<Long> idReservations = source.getReservations().stream().map(ReservationDto::getId).collect(Collectors.toList());
			List<Reservation> reservations = reservationService.find(idReservations);
			timetable.setReservations(new HashSet<>(reservations));
			
		
		}
		
		return timetable;
	}
	

}
