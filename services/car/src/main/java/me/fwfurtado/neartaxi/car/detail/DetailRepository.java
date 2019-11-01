package me.fwfurtado.neartaxi.car.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.domain.Brand;

public interface DetailRepository {
    Optional<CarProjection> findCarById(Long id);

    interface CarProjection {
         Brand getBrand();
         String getModel();
         String getLicensePlate();
         Long getOwnerId();
    }
}
