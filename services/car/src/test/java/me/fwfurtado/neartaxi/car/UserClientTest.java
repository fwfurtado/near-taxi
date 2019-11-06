package me.fwfurtado.neartaxi.car;

import me.fwfurtado.neartaxi.car.detail.UserClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "me.fwfurtado.neartaxi:user:+:8090")
@AutoConfigureTestDatabase
public class UserClientTest {

    static {
        System.setProperty("eureka.client.enabled", "false");
        System.setProperty("spring.cloud.config.failFast", "false");
    }

    @Autowired
    private UserClient client;

    @Test
    public void shouldGetAUser() {

        var owner = client.findOwnerById(1L);

        System.out.println(owner.getId());
        System.out.println(owner.getName());
    }

}
