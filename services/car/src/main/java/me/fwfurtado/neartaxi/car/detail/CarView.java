package me.fwfurtado.neartaxi.car.detail;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.car.domain.Brand;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
class CarView {

    private String model;
    private Brand brand;
    private String licensePlate;
    private String ownerName;
}
