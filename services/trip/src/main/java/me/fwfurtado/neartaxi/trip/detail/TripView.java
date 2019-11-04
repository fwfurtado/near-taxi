package me.fwfurtado.neartaxi.trip.detail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.trip.common.CarClient.Car;
import me.fwfurtado.neartaxi.trip.common.UserClient.Customer;
import me.fwfurtado.neartaxi.trip.domain.TripStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class TripView {

    private Long id;
    private LocalDateTime date;
    private TripStatus status;
    private BigDecimal price;

    private Car car;
    private Customer customer;

    private String pickup;
    private String dropOff;
}
