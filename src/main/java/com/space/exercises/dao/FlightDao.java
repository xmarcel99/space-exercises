

package com.space.exercises.dao;

import com.space.exercises.domain.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FlightDao extends CrudRepository<Flight,Long> {

    Flight findById(long id);

    @Query
    List<Flight> findFlightWithFreeSeats();
}
