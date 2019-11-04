package me.fwfurtado.neartaxi.trip.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.trip.common.CarClient;
import me.fwfurtado.neartaxi.trip.common.UserClient;
import me.fwfurtado.neartaxi.trip.domain.Trip;
import org.springframework.stereotype.Service;

@Service
class DetailService {

    private final DetailRepository repository;
    private final UserClient users;
    private final CarClient cars;
    private final TripToTripView converter;

    DetailService(DetailRepository repository, UserClient users, CarClient cars, TripToTripView converter) {
        this.repository = repository;
        this.users = users;
        this.cars = cars;
        this.converter = converter;
    }

    Optional<TripView> showBy(Long id) {

        return repository.findById(id).map(this::enhanceTripRelationships);
    }

    private TripView enhanceTripRelationships(Trip trip) {
        var car = cars.findCarById(trip.getCarId());
        var customer = users.findCustomerById(trip.getCustomerId());

        return converter.convert(trip, car, customer);
    }
}
