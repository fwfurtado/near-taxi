package me.fwfurtado.neartaxi.car.domain;

import java.time.Year;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.car.domain.Brand;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Brand brand;
    private String model;
    private String licensePlate;
    private Year modelYear;
    private Year releaseYear;
    private Long ownerId;

    public Car(Long ownerId, Brand brand, String model, String licensePlate, Year modelYear, Year releaseYear) {
        this.ownerId = ownerId;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.modelYear = modelYear;
        this.releaseYear = releaseYear;
    }
}
