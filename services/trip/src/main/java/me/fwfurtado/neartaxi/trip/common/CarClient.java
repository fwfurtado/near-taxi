package me.fwfurtado.neartaxi.trip.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import feign.hystrix.FallbackFactory;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.trip.common.CarClient.CarClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient(name = "cars", fallbackFactory = CarClientFallback.class)
public interface CarClient {

    @GetMapping("/cars/{id}")
    Car findCarById(@PathVariable("id") Long id);

    @GetMapping("/cars/internal")
    Map<String, String> status();

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Car {
        private Long id;
        private String licensePlate;
        private Owner owner;



    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Owner {
        private Long id;
        private String name;
    }

    @Component
    class CarClientFallback implements FallbackFactory<CarClient> {

        @Override
        public CarClient create(Throwable cause) {
            return  new CarClient() {
                @Override
                public Car findCarById(Long id) {
                    return new Car(id, null, new Owner(null, "Unknown Name"));
                }

                @Override
                public Map<String, String> status() {
                    return Map.of("status", "unknown");
                }
            };
        }
    }
}
