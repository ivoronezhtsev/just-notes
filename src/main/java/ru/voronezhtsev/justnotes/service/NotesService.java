package ru.voronezhtsev.justnotes.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.voronezhtsev.justnotes.controller.NoteModel;
import ru.voronezhtsev.justnotes.entity.User;
import ru.voronezhtsev.justnotes.repository.NotesRepository;
import ru.voronezhtsev.justnotes.entity.Note;
import ru.voronezhtsev.justnotes.repository.UsersRepository;
import ru.voronezhtsev.justnotes.security.AppUserPrincipal;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final NotesRepository notesRepository;
    private final UsersRepository usersRepository;

    public List<Note> findNotes() {
        return notesRepository.findByUserId(getCurrentUser().getUserId());
    }

    public void save(NoteModel noteModel) {
        User user = usersRepository.findByUsername(getCurrentUser().getUsername());
        Note note = new Note(user, noteModel.getTitle(), noteModel.getContent());
        notesRepository.save(note); //todo Попробовать убрать получение пользователя.
    }

    private AppUserPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AppUserPrincipal) authentication.getPrincipal();
    }
}