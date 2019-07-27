package com.space.exercises.dao;

import com.space.exercises.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NoteDao extends CrudRepository<Note,Long> {
}
