package me.fwfurtado.neartaxi.user.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.user.domain.User;

public interface DetailRepository {

    Optional<User> findById(Long id);
}
