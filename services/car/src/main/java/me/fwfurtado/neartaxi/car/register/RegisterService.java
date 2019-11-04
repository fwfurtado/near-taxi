package me.fwfurtado.neartaxi.car.register;

import me.fwfurtado.neartaxi.car.domain.Car;
import me.fwfurtado.neartaxi.car.register.RegisterController.CarForm;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
class RegisterService {

    private final CarFormToCarConverter converter;
    private final RegisterRepository repository;
    private final MessageChannel channel;

    RegisterService(CarFormToCarConverter converter, RegisterRepository repository, @Output(Source.OUTPUT) MessageChannel channel) {
        this.converter = converter;
        this.repository = repository;
        this.channel = channel;
    }

    public Long register(CarForm form) {

        repository.findCarByLicensePlate(form.getLicensePlate())
            .ifPresent(car -> {
                throw new CarAlreadyExistException(car.getLicensePlate());
            });

        Car car = converter.convert(form);

        repository.save(car);

        Message<Car> message = MessageBuilder.withPayload(car).build();

        channel.send(message);

        return car.getId();
    }

}
