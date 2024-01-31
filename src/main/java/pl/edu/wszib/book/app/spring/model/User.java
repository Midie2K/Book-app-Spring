package pl.edu.wszib.book.app.spring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String login;
    private String password;
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
