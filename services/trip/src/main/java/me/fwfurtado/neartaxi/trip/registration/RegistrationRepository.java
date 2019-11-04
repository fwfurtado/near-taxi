package me.fwfurtado.neartaxi.trip.registration;

import me.fwfurtado.neartaxi.trip.domain.Trip;

public interface RegistrationRepository {

    void save(Trip trip);
}
