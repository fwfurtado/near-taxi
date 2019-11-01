package me.fwfurtado.neartaxi.car.detail;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users")
public interface UserClient {

    @GetMapping("{id}")
    OwnerView findOwnerById(@PathVariable("id") Long id);

    @Getter
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @AllArgsConstructor
    class OwnerView {

        private String name;
    }
}