package me.fwfurtado.neartaxi.car.register;

import java.time.Year;
import me.fwfurtado.neartaxi.car.domain.Brand;
import me.fwfurtado.neartaxi.car.register.RegisterController.CarForm;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
public class RegistrationBase {

    @Autowired
    private RegisterService service;

    public void publish() {

        CarForm uno = new CarForm(1L, Brand.FIAT, "Uno", Year.of(2019), Year.of(2019), "ABC-1234");

        service.register(uno);
    }
}
