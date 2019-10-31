package me.fwfurtado.neartaxi.infra;

import me.fwfurtado.neartaxi.detail.DetailRepository;
import me.fwfurtado.neartaxi.domain.Car;
import me.fwfurtado.neartaxi.register.RegisterRepository;
import org.springframework.data.repository.Repository;

interface CarRepository extends Repository<Car, Long>, RegisterRepository, DetailRepository {

}
