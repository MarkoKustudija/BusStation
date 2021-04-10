package bus.station.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Reservation;
import bus.station.model.Timetable;
import bus.station.web.dto.TimetableDto;
@Component
public class TimetableToTimetableDto implements Converter<Timetable, TimetableDto>{
	
	@Autowired
	private ReservationToReservationDto toDto;
	

	@Override
	public TimetableDto convert(Timetable source) {
		TimetableDto dto = new TimetableDto();
		dto.setId(source.getId());
		dto.setNumberOfSeats(source.getNumberOfSeats());
		dto.setTicketPrice(source.getTicketPrice());
		dto.setDepartureTime(source.getDepartureTime());
		dto.setDestination(source.getDestination());
		dto.setCompanyId(source.getCompany().getId());
		
		List<Reservation> reservations = new ArrayList<>(source.getReservations());
		dto.setReservations(new HashSet<>(toDto.convert(reservations)));
		
		return dto;
	}
	
	public List<TimetableDto> convert(List<Timetable> timetables) {
		List<TimetableDto>timetableDtos = new ArrayList<>();
		for(Timetable t : timetables) {
			timetableDtos.add(convert(t));
		}
		return timetableDtos;
	}

	

}
