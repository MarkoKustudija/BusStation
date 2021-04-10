package bus.station.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import bus.station.model.Company;
import bus.station.model.Timetable;
import bus.station.repository.CompanyRepository;
import bus.station.repository.TimetableRepository;
import bus.station.service.TimetableService;
import bus.station.web.dto.TimetableDto;

@Service
public class JpaTimetableService implements TimetableService {
	
	@Autowired
	private TimetableRepository timetableRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	

	@Override
	public Timetable findOne(Long id) {
		return timetableRepository.findOneById(id);
	}

	@Override
	public List<Timetable> findAll() {
		return timetableRepository.findAll();
	}

	@Override
	public Page<Timetable> findAll(Pageable pageable) {
		return timetableRepository.findAll(pageable);
	}

	@Override
	public List<Timetable> find(List<Long> idS) {
		return timetableRepository.findByIdIn(idS);
	}

	@Override
	public Timetable save(Timetable timetable) {
		return timetableRepository.save(timetable);
	}

	@Override
	public Timetable update(Timetable timetable) {
		return timetableRepository.save(timetable);
	}

	@Override
	public Timetable delete(Long id) {
		Optional<Timetable> timetableOptional = timetableRepository.findById(id);
		if(timetableOptional.isPresent()){
			
			Timetable timetable = timetableOptional.get();
			
			Company company = timetable.getCompany();
			company.setId(id);
			company.removeTimetable(timetable.getId());
			
			companyRepository.save(company);
			timetableRepository.deleteById(id);
			
			return timetable;
			
			
		}
		return null;
	}

	@Override
	public Page<Timetable> search(Long id, int pageNum) {
		return timetableRepository.search(id, PageRequest.of(pageNum, 4));
	}

	@Override
	public Timetable save(TimetableDto timetableDto) {
		
		return null;
	}

	@Override
	public Optional<Timetable> one(Long id) {
		return timetableRepository.findById(id);
	}
	

}
