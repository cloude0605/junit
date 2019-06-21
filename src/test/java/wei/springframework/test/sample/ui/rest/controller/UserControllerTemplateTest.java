package wei.springframework.test.sample.ui.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import wei.springframework.test.sample.ui.rest.model.RegisterRequest;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * UserControllerTemplateTest.
 * TODO
 * 2019-06-20 22:17
 *
 * @author wei
 * @version 1.0.0
 **/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void register() {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setAccount("test@gmail.com");
        registerRequest.setPassword("123123");
        registerRequest.setName("Hello");

        UserDto response = restTemplate.postForObject("/rest/v1/users/register", registerRequest, UserDto.class);

        assertAll(
                () -> assertEquals("test@gmail.com", response.getAccount(), "account not equal"),
                () -> assertEquals(new Long(1), response.getId()),
                () -> assertEquals("Hello", response.getName())
        );
    }

}
