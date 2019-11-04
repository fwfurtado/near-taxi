package me.fwfurtado.neartaxi.trip.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.trip.common.UserClient.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("{id}")
    Customer findCustomerById(@PathVariable("id") Long id);

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    class Customer {

        private Long id;
        private String name;
    }

    @Component
    class UserClientFallback implements UserClient {

        @Override
        public Customer findCustomerById(Long id) {
            return new Customer(id, "Unknown Name");
        }
    }
}
