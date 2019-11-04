package me.fwfurtado.neartaxi.trip.detail;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DetailController {

    private final DetailService service;

    DetailController(DetailService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    ResponseEntity<?> show(@PathVariable Long id) {
        return service.showBy(id).map(ok()::body).orElseGet(notFound()::build);
    }
}
