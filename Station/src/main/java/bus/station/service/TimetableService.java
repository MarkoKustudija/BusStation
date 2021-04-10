package bus.station.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bus.station.model.Timetable;
import bus.station.web.dto.TimetableDto;


public interface TimetableService {
	
	Timetable findOne(Long id);
	
	List<Timetable> findAll();
	
	Page<Timetable> findAll(Pageable pageable);

	List<Timetable> find(List<Long> idS);

	Timetable save(Timetable timetable);
		
	Timetable update(Timetable timetable);

	Timetable delete(Long id);

	Page<Timetable> search (Long id, int pageNum);
	
    Timetable save(TimetableDto timetableDto);
	
	Optional<Timetable> one(Long id);

}
