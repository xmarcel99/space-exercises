
package com.space.exercises.dao;

import com.space.exercises.domain.Tourist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TouristDao  extends CrudRepository<Tourist,Long> {

}