package ru.voronezhtsev.justnotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronezhtsev.justnotes.entity.User;
import ru.voronezhtsev.justnotes.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public List<User> list() {
        return usersRepository.findAll();
    }
}
