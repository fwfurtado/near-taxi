package me.fwfurtado.neartaxi.trip.listener;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;

import me.fwfurtado.neartaxi.trip.listener.CarListener.CreatedCarEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "me.fwfurtade.neartaxi.car:+:stubs")
public class CarListenerTest {

    @Autowired
    private StubTrigger trigger;

    @MockBean
    private CarService service;

    @Captor
    private ArgumentCaptor<CreatedCarEvent> eventCaptor;

    @Test
    public void shouldReceiveACreatedCarEvent() {

        trigger.trigger("publish_car");

        then(service).should().saveBy(eventCaptor.capture());

        var event = eventCaptor.getValue();

        assertEquals("FIAT", event.getBrand());

    }
}