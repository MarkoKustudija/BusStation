package bus.station.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bus.station.model.Reservation;
import bus.station.service.ReservationService;
import bus.station.support.ReservationToReservationDto;
import bus.station.web.dto.ReservationDto;

@RestController
@RequestMapping(value = "/api/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationToReservationDto toDto;
	
	@GetMapping
	public ResponseEntity<List<ReservationDto>> getAll(){
		
		List<Reservation> reservations = reservationService.findAll();
		return new ResponseEntity<>(toDto.convert(reservations), HttpStatus.OK);
		
	}
}
