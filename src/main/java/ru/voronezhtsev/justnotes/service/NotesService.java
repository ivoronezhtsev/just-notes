package ru.voronezhtsev.justnotes.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.voronezhtsev.justnotes.repository.NotesRepository;
import ru.voronezhtsev.justnotes.entity.Note;
import ru.voronezhtsev.justnotes.security.AppUserPrincipal;

import java.util.List;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Note> findNotes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((AppUserPrincipal) authentication.getPrincipal()).getUserId();
        return notesRepository.findByUserId(userId);
    }

}