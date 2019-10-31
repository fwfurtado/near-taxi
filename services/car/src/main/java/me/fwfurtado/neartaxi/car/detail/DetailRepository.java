package me.fwfurtado.neartaxi.car.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.detail.DetailController.CarView;

public interface DetailRepository {
    Optional<CarView> findCarById(Long id);
}
