package me.fwfurtado.neartaxi.trip.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.fwfurtado.neartaxi.trip.commands.UpdatePriceCommand;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private Long customerId;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private BigDecimal price;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "latitude", column = @Column(name = "pickup_latitude")),
        @AttributeOverride(name = "longitude", column = @Column(name = "pickup_longitude"))
    })
    private Location pickup;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "latitude", column = @Column(name = "drop_off_latitude")),
        @AttributeOverride(name = "longitude", column = @Column(name = "drop_off_longitude"))
    })
    private Location dropOff;

    public Trip(Long carId, Long customerId, LocalDateTime date, TripStatus status, Location pickup, Location dropOff) {
        this.carId = carId;
        this.customerId = customerId;
        this.date = date;
        this.status = status;
        this.pickup = pickup;
        this.dropOff = dropOff;
    }

    public void updatePrice(UpdatePriceCommand updatePrice) {
        this.price = updatePrice.getPrice();
    }
}
