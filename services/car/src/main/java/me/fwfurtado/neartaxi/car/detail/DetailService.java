package me.fwfurtado.neartaxi.car.detail;

import java.util.Optional;
import me.fwfurtado.neartaxi.car.detail.DetailRepository.CarProjection;
import me.fwfurtado.neartaxi.car.detail.UserClient.OwnerView;
import org.springframework.stereotype.Service;

@Service
class DetailService {

    private final UserClient userClient;
    private final DetailRepository repository;

    DetailService(UserClient userClient, DetailRepository repository) {
        this.userClient = userClient;
        this.repository = repository;
    }

    Optional<CarView> findById(Long id) {
        return repository.findCarById(id).map(this::enhanceOwner);
    }

    private CarView enhanceOwner(CarProjection projection) {

        OwnerView owner = userClient.findOwnerById(projection.getOwnerId());

        return createCarBy(projection, owner.getName());
    }

    private CarView createCarBy(CarProjection projection, String ownerName) {
        return new CarView(projection.getModel(), projection.getBrand(), projection.getLicensePlate(), ownerName);
    }

}
