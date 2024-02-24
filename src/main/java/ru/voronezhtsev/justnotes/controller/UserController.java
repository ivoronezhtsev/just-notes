package ru.voronezhtsev.justnotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.voronezhtsev.justnotes.entity.User;
import ru.voronezhtsev.justnotes.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "users";
    }
}