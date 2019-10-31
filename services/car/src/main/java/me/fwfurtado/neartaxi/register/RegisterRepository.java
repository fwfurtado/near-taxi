package me.fwfurtado.neartaxi.register;

import java.util.Optional;
import me.fwfurtado.neartaxi.domain.Car;

public interface RegisterRepository {

    void save(Car car);

    Optional<Car> findCarByLicensePlate(String licensePlate);
}
