package me.fwfurtado.neartaxi.gateway.login;

import org.springframework.stereotype.Component;

@Component
class UserToResourceOwner {

    ResourceOwner convert(User user) {
        return new ResourceOwner(user.getEmail(), user.getPassword(), user.getRoles());
    }
}
