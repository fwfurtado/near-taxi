package me.fwfurtado.neartaxi.trip.commands;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePriceCommand {

    private final BigDecimal price;

}
