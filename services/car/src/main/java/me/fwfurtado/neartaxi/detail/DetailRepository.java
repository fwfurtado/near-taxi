package me.fwfurtado.neartaxi.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.detail.DetailController.CarView;

public interface DetailRepository {
    Optional<CarView> findCarById(Long id);
}
