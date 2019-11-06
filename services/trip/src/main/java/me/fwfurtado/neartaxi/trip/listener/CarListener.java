package me.fwfurtado.neartaxi.trip.listener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
class CarListener {

    private final CarService service;

    CarListener(CarService service) {
        this.service = service;
    }

    @StreamListener(Sink.INPUT)
    void handle(CreatedCarEvent event) {
        service.saveBy(event);
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class CreatedCarEvent  {
        private Long ownerId;
        private String model;
        private String brand;

        @Override
        public String toString() {
            return new StringJoiner(", ", CreatedCarEvent.class.getSimpleName() + "[", "]")
                .add("ownerId=" + ownerId)
                .add("model='" + model + "'")
                .add("brand='" + brand + "'")
                .toString();
        }
    }

}
