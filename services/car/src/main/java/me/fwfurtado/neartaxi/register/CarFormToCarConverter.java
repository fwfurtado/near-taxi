package me.fwfurtado.neartaxi.register;

import me.fwfurtado.neartaxi.domain.Car;
import me.fwfurtado.neartaxi.register.RegisterController.CarForm;
import org.springframework.stereotype.Component;

@Component
class CarFormToCarConverter {

    Car convert(CarForm form) {
        return new Car(form.getOwnerId(), form.getBrand(), form.getModel(), form.getLicensePlate(), form.getReleaseYear(), form.getModelYear());
    }

}
