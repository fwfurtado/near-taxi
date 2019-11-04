package me.fwfurtado.neartaxi.user.detail;

import static org.mockito.BDDMockito.given;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import me.fwfurtado.neartaxi.user.domain.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public abstract class DetailBase {

    @Mock
    private DetailRepository repository;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new DetailController(repository));

        User user = new User("Fernando");

        ReflectionTestUtils.setField(user, "id", 1L);

        given(repository.findById(1L)).willReturn(Optional.of(user));

    }
}
