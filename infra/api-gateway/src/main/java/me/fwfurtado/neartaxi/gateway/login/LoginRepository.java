package me.fwfurtado.neartaxi.gateway.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private static final Map<String, User> database = new HashMap<>();

    static {
        var fernando = new User("fernando@caelum.com.br", "{bcrypt}$2a$10$OaDOpYizDTt1dwC6Tf3XZeE1YYmCPvP4n13pNIiWG4fWYDygRBMZu", "ROLE_USER");

        database.put(fernando.getEmail(), fernando);
    }

    Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(database.get(email));
    }
}
