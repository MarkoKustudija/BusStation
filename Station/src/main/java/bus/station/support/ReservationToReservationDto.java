package bus.station.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bus.station.model.Reservation;
import bus.station.web.dto.ReservationDto;

@Component
public class ReservationToReservationDto implements Converter<Reservation, ReservationDto>{

	@Override
	public ReservationDto convert(Reservation source) {
		ReservationDto dto = new ReservationDto();
		dto.setId(source.getId());
		dto.setTimetableId(source.getTimetable().getId());
		return dto;
	}

	public List<ReservationDto> convert(List<Reservation> reservations) {
		List<ReservationDto> reservationDtos = new ArrayList<>();
		for(Reservation r : reservations) {
			reservationDtos.add(convert(r));
		}
		
		return reservationDtos;
	}

}
