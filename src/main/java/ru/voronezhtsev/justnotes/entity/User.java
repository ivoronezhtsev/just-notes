package ru.voronezhtsev.justnotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    LocalDateTime registrationDate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Note> notes;

    public User(long id) {
        this.id = id;
    }
}
