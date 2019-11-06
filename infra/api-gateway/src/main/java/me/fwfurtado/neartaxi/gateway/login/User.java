package me.fwfurtado.neartaxi.gateway.login;

import java.util.List;
import lombok.Getter;

@Getter
public class User {

    private String email;
    private String password;
    private List<String> roles;

    public User(String email, String password, String... roles) {
        this.email = email;
        this.password = password;
        this.roles = List.of(roles);
    }
}
