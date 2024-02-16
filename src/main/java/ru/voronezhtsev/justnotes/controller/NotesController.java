package ru.voronezhtsev.justnotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.voronezhtsev.justnotes.entity.Note;
import ru.voronezhtsev.justnotes.service.NotesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NotesController {

    private final NotesService notesService;

    @GetMapping("/")
    public String showNotes(Model model) {
        List<Note> notes = notesService.findNotes();
        model.addAttribute("notes", notes);
        return "index";
    }

}
