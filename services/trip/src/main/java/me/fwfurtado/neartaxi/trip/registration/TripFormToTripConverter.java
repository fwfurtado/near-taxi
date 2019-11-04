package me.fwfurtado.neartaxi.trip.registration;

import java.time.LocalDateTime;
import me.fwfurtado.neartaxi.trip.domain.Trip;
import me.fwfurtado.neartaxi.trip.domain.TripStatus;
import me.fwfurtado.neartaxi.trip.registration.RegistrationController.TripForm;
import org.springframework.stereotype.Component;

@Component
class TripFormToTripConverter {

    Trip convert(TripForm form) {
        return new Trip(form.getCarId(), form.getCustomerId(), LocalDateTime.now(), TripStatus.WAITING_FOR_APPROVAL, form.getPickup(), form.getDropOff());
    }
}
