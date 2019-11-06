package me.fwfurtado.neartaxi.gateway.login;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
class LoginService implements UserDetailsService {

    private final LoginRepository repository;
    private final UserToResourceOwner converter;

    LoginService(LoginRepository repository, UserToResourceOwner converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
            .findUserByEmail(username)
            .map(converter::convert)
            .orElseThrow(() -> new UsernameNotFoundException("Cannot find user"));
    }
}
