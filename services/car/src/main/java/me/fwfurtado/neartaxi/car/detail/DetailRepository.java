package me.fwfurtado.neartaxi.car.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.domain.Brand;

public interface DetailRepository {

    Optional<CarProjection> findCarById(Long id);

    interface CarProjection {

        Long getId();

        Brand getBrand();

        String getModel();

        String getLicensePlate();

        Long getOwnerId();
    }
}
