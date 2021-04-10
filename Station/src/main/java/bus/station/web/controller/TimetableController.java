package bus.station.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bus.station.model.Timetable;
import bus.station.service.TimetableService;
import bus.station.support.TimetableDtoToTimetable;
import bus.station.support.TimetableToTimetableDto;
import bus.station.web.dto.TimetableDto;

@RestController
@RequestMapping(value = "api/timetables", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimetableController {
	
	@Autowired
	private TimetableService timetableService;
	@Autowired
	private TimetableToTimetableDto toDto;
	@Autowired 
	private TimetableDtoToTimetable toTimetable;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TimetableDto> getOne(@PathVariable Long id){
		Timetable timetable = timetableService.findOne(id);
		if(timetable != null) {
			return new ResponseEntity<>(toDto.convert(timetable), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<TimetableDto>> getAll(@RequestParam (required = false) Long id,
			    @RequestParam(required = false, defaultValue = "0")int pageNo){
		Page<Timetable> pageTimetable;
		if(id != null) {
			pageTimetable = timetableService.search(id, pageNo);
		}else {
			pageTimetable = timetableService.findAll(PageRequest.of(pageNo, 4));	
			}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Total-Pages", pageTimetable.getTotalPages() + "");
		
		return new ResponseEntity<>(toDto.convert(pageTimetable.getContent()), responseHeaders, HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimetableDto> create (@RequestParam TimetableDto timetableDto){
		Timetable timetable = toTimetable.convert(timetableDto);
		Timetable savedTimetable = timetableService.save(timetable);
		
		return new ResponseEntity<>(toDto.convert(savedTimetable), HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")				
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimetableDto> update(@PathVariable Long id, @RequestBody TimetableDto timetableDto){
		
		if(!id.equals(timetableDto.getId())) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Timetable timetable = toTimetable.convert(timetableDto);
		Timetable savedTimetable = timetableService.update(timetable);
		
		return new ResponseEntity<>(toDto.convert(savedTimetable), HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<TimetableDto> delete(@PathVariable Long id){
		
		Timetable deleted = timetableService.delete(id);
		if(deleted == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(toDto.convert(deleted),HttpStatus.OK);
		
		}
	}
	
	
	
}


