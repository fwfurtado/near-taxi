package me.fwfurtado.neartaxi.user.infra;

import me.fwfurtado.neartaxi.user.detail.DetailRepository;
import me.fwfurtado.neartaxi.user.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Long>, DetailRepository {

}
