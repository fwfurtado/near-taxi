package me.fwfurtado.neartaxi.common;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorPayload {

    private final LocalDateTime date = LocalDateTime.now();

    private String reason;

    public static ErrorPayload of(Exception exception) {
        return new ErrorPayload(exception.getMessage());
    }

}
