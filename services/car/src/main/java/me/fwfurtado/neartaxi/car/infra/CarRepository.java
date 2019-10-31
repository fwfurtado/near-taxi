package me.fwfurtado.neartaxi.car.infra;

import me.fwfurtado.neartaxi.car.detail.DetailRepository;
import me.fwfurtado.neartaxi.car.domain.Car;
import me.fwfurtado.neartaxi.car.register.RegisterRepository;
import org.springframework.data.repository.Repository;

interface CarRepository extends Repository<Car, Long>, RegisterRepository, DetailRepository {

}
