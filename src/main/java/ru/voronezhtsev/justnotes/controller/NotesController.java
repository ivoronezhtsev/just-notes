package ru.voronezhtsev.justnotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("note", new NoteModel());
        return "note-info";
    }

    @GetMapping("save")
    public String save(@ModelAttribute NoteModel noteModel) {
        notesService.save(noteModel);
        return "redirect:/";
    }

    @PostMapping("/delete/{noteId}")
    public String delete(@PathVariable Long noteId) {
        notesService.delete(noteId);
        return "redirect:/";
    }

}
