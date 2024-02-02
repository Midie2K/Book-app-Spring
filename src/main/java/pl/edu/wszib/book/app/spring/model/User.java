package pl.edu.wszib.book.app.spring.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private String name;
    private String surname;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    public User(String login, String password, String name, String surname){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
