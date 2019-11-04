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

    private Long id;
    private String model;
    private Brand brand;
    private String licensePlate;
    private Owner owner;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    static class Owner {
        private Long id;
        private String name;
    }
}
