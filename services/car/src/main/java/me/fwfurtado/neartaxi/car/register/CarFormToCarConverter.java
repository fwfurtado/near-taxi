package me.fwfurtado.neartaxi.car.register;

import me.fwfurtado.neartaxi.car.domain.Car;
import me.fwfurtado.neartaxi.car.register.RegisterController.CarForm;
import org.springframework.stereotype.Component;

@Component
class CarFormToCarConverter {

    Car convert(CarForm form) {
        return new Car(form.getOwnerId(), form.getBrand(), form.getModel(), form.getLicensePlate(), form.getReleaseYear(), form.getModelYear());
    }

}
