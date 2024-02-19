package ru.voronezhtsev.justnotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronezhtsev.justnotes.controller.NoteModel;
import ru.voronezhtsev.justnotes.entity.Note;
import ru.voronezhtsev.justnotes.entity.User;
import ru.voronezhtsev.justnotes.repository.NotesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final NotesRepository notesRepository;

    public List<Note> findNotes() {
        return notesRepository.findByUserId(1);
    }

    public void save(NoteModel noteModel) {
        Note note = new Note(new User(1L), noteModel.getTitle(), noteModel.getContent());
        notesRepository.save(note);
    }

    /*private AppUserPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AppUserPrincipal) authentication.getPrincipal();
    }*/

    public void delete(long noteId) {
        notesRepository.deleteById(noteId);
    }
}
