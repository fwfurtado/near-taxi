package me.fwfurtado.neartaxi.car.register;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.time.Year;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.car.domain.Brand;
import me.fwfurtado.neartaxi.lib.ErrorPayload;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
class RegisterController {

    private final RegisterService registration;

    RegisterController(RegisterService registration) {
        this.registration = registration;
    }

    @PostMapping
    @CacheEvict(cacheNames = "cars")
    public ResponseEntity<?> create(@RequestBody CarForm form, UriComponentsBuilder uriBuilder) {
        Long id = registration.register(form);

        URI resourceLocation = uriBuilder.path("{id}").build(id);

        return created(resourceLocation).build();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @AllArgsConstructor
    static class CarForm {

        private Long ownerId;
        private Brand brand;
        private String model;
        private Year modelYear;
        private Year releaseYear;
        private String licensePlate;
    }

    @RestControllerAdvice
    @Order(Ordered.HIGHEST_PRECEDENCE)
    static class RegisterErrorHandling {

        @ExceptionHandler(CarAlreadyExistException.class)
        ResponseEntity<?> alreadyExist(CarAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorPayload.of(e));
        }
    }
}
