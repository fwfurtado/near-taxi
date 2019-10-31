package me.fwfurtado.neartaxi.user.detail;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DetailController {

    private final DetailRepository repository;

    DetailController(DetailRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    ResponseEntity<?> show(@PathVariable Long id) {
        return repository.findById(id).map(ok()::body).orElseGet(notFound()::build);
    }

}
