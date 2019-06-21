package wei.springframework.test.sample.ui.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.service.UserService;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserViewControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserViewController userViewController;

    MockMvc mockMvc;

    UserDto userDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userViewController).build();

        final String account = "TestAccount";
        final String name = "Hello";

        userDto = UserDto.builder().id(1l).account(account).name(name).build();
    }

    @Test
    void register() throws Exception {
        given(userService.register(anyString(), anyString(), anyString())).willReturn(userDto);

        mockMvc.perform(post("/v1/users/register")
                .param("account", "test@gmail.com")
                .param("password", "123123")
                .param("name", "test"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("id", "account", "name"))
                .andExpect(view().name("view/register"))
                .andReturn();
    }

    @Test
    void login() throws Exception {
        given(userService.login(anyString(), anyString())).willReturn(userDto);

        mockMvc.perform(post("/v1/users/login")
                .param("account", "test@gmail.com")
                .param("password", "123123"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("id", "account", "name"))
                .andExpect(view().name("view/login"))
                .andReturn();
    }
}