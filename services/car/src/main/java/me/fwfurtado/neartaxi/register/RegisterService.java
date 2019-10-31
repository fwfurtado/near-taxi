package me.fwfurtado.neartaxi.register;

import me.fwfurtado.neartaxi.domain.Car;
import me.fwfurtado.neartaxi.register.RegisterController.CarForm;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private final CarFormToCarConverter converter;
    private final RegisterRepository repository;

    RegisterService(CarFormToCarConverter converter, RegisterRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    Long register(CarForm form) {

        repository.findCarByLicensePlate(form.getLicensePlate())
            .ifPresent(car -> { throw new CarAlreadyExistException(car.getLicensePlate());}
            );

        Car car = converter.convert(form);

        repository.save(car);

        return car.getId();
    }

}
