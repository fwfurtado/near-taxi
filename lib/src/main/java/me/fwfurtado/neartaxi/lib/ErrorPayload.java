package me.fwfurtado.neartaxi.lib;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorPayload {

    private final LocalDateTime date = LocalDateTime.now();

    private String reason;

    public static ErrorPayload of(Exception exception) {
        return new ErrorPayload(exception.getMessage());

    }
}