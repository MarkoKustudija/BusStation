package bus.station.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bus.station.model.Timetable;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long>{

	Timetable findOneById(Long id);

	List<Timetable> findByIdIn(List<Long> idS);
	
	@Query("SELECT t FROM Timetable t WHERE : timetableId = NULL OR t.id = :timetableId")
	Page<Timetable> search(@Param("timetableId") Long id, Pageable pageable);

	

}
