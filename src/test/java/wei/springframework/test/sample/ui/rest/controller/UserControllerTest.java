package wei.springframework.test.sample.ui.rest.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import wei.springframework.test.sample.service.UserService;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    UserDto userDto;

    @BeforeEach
    void setUp() {
        final String account = "TestAccount";
        final String name = "Hello";

        userDto = UserDto.builder().account(account).name(name).build();
    }

    @Test
    void register() throws Exception {
        given(userService.register(anyString(), anyString(), anyString())).willReturn(userDto);

        MvcResult result = mockMvc.perform(post("/rest/v1/users/register")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"account\": \"vloude0605@gmail.com\",\n" +
                        "\t\"password\": \"123123\",\n" +
                        "\t\"name\": \"wei\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.account", Is.is("TestAccount")))
                .andExpect(jsonPath("$.name", Is.is("Hello")))
                .andReturn();

        System.out.println("result: " + result.getResponse().getContentAsString());
    }

}