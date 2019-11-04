package me.fwfurtado.neartaxi.trip.registration;

import me.fwfurtado.neartaxi.trip.registration.RegistrationController.TripForm;
import org.springframework.stereotype.Service;

@Service
class RegistrationService {

    private final TripFormToTripConverter converter;
    private final RegistrationRepository repository;

    RegistrationService(TripFormToTripConverter converter, RegistrationRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    Long register(TripForm form) {

        var trip = converter.convert(form);

        repository.save(trip);

        return trip.getId();
    }
}
