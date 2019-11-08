package me.fwfurtado.neartaxi.trip.internal;

import java.util.Map;
import me.fwfurtado.neartaxi.trip.common.CarClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internal")
public class InternalController {

    private final CarClient client;

    public InternalController(CarClient client) {
        this.client = client;
    }

    @GetMapping
    Map<String, String> status() {
        return client.status();
    }
}
