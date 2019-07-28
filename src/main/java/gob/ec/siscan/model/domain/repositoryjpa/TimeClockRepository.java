package gob.ec.siscan.model.domain.repositoryjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gob.ec.siscan.domain.model.TimeClock;

/**
 * 
 */
public interface TimeClockRepository extends JpaRepository<TimeClock, Long>,CrudRepository<TimeClock, Long> {
    
    
    @Query("select t from TimeClock t where t.id_time_clock=:Idtime")
    public Optional<TimeClock> findByTimeId(@Param("Idtime") Long Idtime);

}
