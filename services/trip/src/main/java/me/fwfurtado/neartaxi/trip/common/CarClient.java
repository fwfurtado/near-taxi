package me.fwfurtado.neartaxi.trip.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.trip.common.CarClient.CarClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cars", fallback = CarClientFallback.class)
public interface CarClient {

    @GetMapping("{id}")
    Car findCarById(@PathVariable("id") Long id);


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    class Car {
        private Long id;
        private Owner owner;

        @Getter
        @AllArgsConstructor
        @NoArgsConstructor(access = AccessLevel.PACKAGE)
        class Owner {
            private Long id;
            private String name;
        }

    }

    @Component
    class CarClientFallback implements CarClient {

        @Override
        public Car findCarById(Long id) {
            return new Car(id, null);
        }
    }
}
