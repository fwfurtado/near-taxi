package me.fwfurtado.neartaxi.car.internal;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars/internal")
class InternalController {

    @GetMapping
    Map<String, String> status() {
        return Map.of("status", "up");
    }

}
