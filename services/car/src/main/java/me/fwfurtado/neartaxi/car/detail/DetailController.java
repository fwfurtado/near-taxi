package me.fwfurtado.neartaxi.car.detail;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class DetailController {

    private final DetailService service;
    private final int count;

    DetailController(DetailService service, @Value("${cars.counter}") int count) {
        this.service = service;
        this.count = count;
    }

    @GetMapping("{id}")
    @Cacheable(cacheNames = "cars", key = "#id")
    public ResponseEntity<?> show(@PathVariable Long id) {
        System.out.println(this);

        return service.findById(id)
            .map(this::addHeader)
            .orElseGet(notFound()::build);
    }

    private ResponseEntity<?> addHeader(CarView carView) {
        return ok().header("SERVER_COUNT", String.valueOf(count)).body(carView);
    }

}
