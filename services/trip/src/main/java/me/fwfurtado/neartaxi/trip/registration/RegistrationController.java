package me.fwfurtado.neartaxi.trip.registration;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
class RegistrationController {

    private final RegistrationService service;

    RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@RequestBody TripForm form, UriComponentsBuilder uriBuilder) {
        Long id = service.register(form);

        URI uri = uriBuilder.path("{id}").build(id);

        return created(uri).build();
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    static class TripForm {

        private Long carId;
        private Long customerId;
        private String pickup;
        private String dropOff;
    }
}
