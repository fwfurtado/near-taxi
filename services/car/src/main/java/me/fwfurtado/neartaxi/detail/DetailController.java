package me.fwfurtado.neartaxi.detail;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Optional;
import me.fwfurtado.neartaxi.domain.Brand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DetailController {

    private final DetailService service;
    private final int port;

    DetailController(DetailService service, @Value("${server.port}") int port) {
        this.service = service;
        this.port = port;
    }

    @GetMapping("{id}")
    ResponseEntity<?> show(@PathVariable Long id) {
        Optional<CarView> optionalCar = service.findById(id);

        return optionalCar
            .map(this::addHeader)
            .orElseGet(notFound()::build);
    }

    private ResponseEntity<?> addHeader(CarView carView) {

        return ok().header("SERVER_PORT", String.valueOf(port)).body(carView);
    }

    interface CarView {
         Brand getBrand();
         String getModel();
         String getLicensePlate();
    }
}
