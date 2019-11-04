package me.fwfurtado.neartaxi.trip.infra;

import me.fwfurtado.neartaxi.trip.detail.DetailRepository;
import me.fwfurtado.neartaxi.trip.domain.Trip;
import me.fwfurtado.neartaxi.trip.registration.RegistrationRepository;
import org.springframework.data.repository.Repository;

interface TripRepository extends Repository<Trip, Long>, RegistrationRepository, DetailRepository {

}
