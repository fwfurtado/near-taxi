package me.fwfurtado.neartaxi.car.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.detail.DetailController.CarView;
import org.springframework.stereotype.Service;

@Service
class DetailService {

    private final DetailRepository repository;

    DetailService(DetailRepository repository) {
        this.repository = repository;
    }

    Optional<CarView> findById(Long id) {
        return repository.findCarById(id);
    }
}
