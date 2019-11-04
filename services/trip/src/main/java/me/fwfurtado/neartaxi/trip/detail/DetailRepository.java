package me.fwfurtado.neartaxi.trip.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.trip.domain.Trip;

public interface DetailRepository {

    Optional<Trip> findById(Long id);
}
