package ru.voronezhtsev.justnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.voronezhtsev.justnotes.entity.Note;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
}
