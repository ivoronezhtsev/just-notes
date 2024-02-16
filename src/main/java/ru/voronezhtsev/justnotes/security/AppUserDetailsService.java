package ru.voronezhtsev.justnotes.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.voronezhtsev.justnotes.entity.User;
import ru.voronezhtsev.justnotes.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public AppUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserPrincipal(user);
    }
}