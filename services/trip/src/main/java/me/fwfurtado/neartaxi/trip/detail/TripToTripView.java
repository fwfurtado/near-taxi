package me.fwfurtado.neartaxi.trip.detail;

import me.fwfurtado.neartaxi.trip.common.CarClient.Car;
import me.fwfurtado.neartaxi.trip.common.UserClient.Customer;
import me.fwfurtado.neartaxi.trip.domain.Trip;
import org.springframework.stereotype.Component;

@Component
class TripToTripView {

    TripView convert(Trip trip, Car car, Customer customer) {
        return new TripView(trip.getId(), trip.getDate(), trip.getStatus(), trip.getPrice(), car, customer, trip.getPickup(), trip.getDropOff());
    }
}
