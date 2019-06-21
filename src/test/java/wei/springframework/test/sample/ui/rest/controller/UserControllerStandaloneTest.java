package wei.springframework.test.sample.ui.rest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.service.UserService;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * UserControllerStandaloneTest.
 * TODO
 * 2019-06-20 22:20
 *
 * @author wei
 * @version 1.0.0
 **/
@ExtendWith(MockitoExtension.class)
public class UserControllerStandaloneTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    MockMvc mockMvc;

    User user;

    UserDto userDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        final String account = "TestAccount";
        final String name = "Hello";

        user = User.builder()
                .account(account)
                .password("12341234")
                .name(name)
                .build();

        userDto = UserDto.builder().id(1l).account(account).name(name).build();

    }

    @Test
    void register() throws Exception {
        given(userService.login(anyString(), anyString())).willReturn(userDto);

        MvcResult result = mockMvc.perform(post("/rest/v1/users/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"account\": \"TestAccount\",\n" +
                        "\t\"password\": \"123123\"" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.account", is("TestAccount")))
                .andExpect(jsonPath("$.name", is("Hello")))
                .andReturn();

        System.out.println("result: " + result.getResponse().getContentAsString());
    }
}
