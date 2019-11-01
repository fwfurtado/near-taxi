package me.fwfurtado.neartaxi.car.detail;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.car.detail.UserClient.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("{id}")
    OwnerView findOwnerById(@PathVariable("id") Long id);

    @Getter
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @AllArgsConstructor
    class OwnerView {

        private String name;
    }

    @Component
    class UserClientFallback implements UserClient {
        @Override
        public OwnerView findOwnerById(Long id) {
            return new OwnerView("Unknown");
        }
    }
}