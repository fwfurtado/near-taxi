package me.fwfurtado.neartaxi.car.register;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.domain.Car;

public interface RegisterRepository {

    void save(Car car);

    Optional<Car> findCarByLicensePlate(String licensePlate);
}
