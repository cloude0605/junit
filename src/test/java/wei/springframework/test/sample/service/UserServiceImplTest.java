package wei.springframework.test.sample.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.persistence.respository.UserRepository;
import wei.springframework.test.sample.ui.rest.mappers.UserMapper;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    User user;

    UserDto userDto;

    @Captor
    ArgumentCaptor<User> argumentCaptor;

    @BeforeEach
    void setUp() {
        final String account = "TestAccount";

        final String name = "Hello";
        user = User.builder()
                .account(account)
                .password("12341234")
                .name(name)
                .build();

        userDto = UserDto.builder().account(account).name(name).build();
    }

    @AfterEach
    void tearDown() {
        // 重置userRepository
        reset(userRepository);
    }

    @Test
    void register() {

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto target = userService.register(user.getAccount(), user.getPassword(), user.getName());

        assertThat("TestAccount").isEqualTo(user.getAccount());
        assertThat("12341234").isEqualTo(user.getPassword());
        assertThat("Hello").isEqualTo(user.getName());

        verify(userRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getId()).isEqualTo(1);
    }

    @Test
    void registerBDD() {
        // given
        given(userRepository.save(any(User.class))).willReturn(user);

        // when
        userService.register(user.getAccount(), user.getPassword(), user.getName());

        // then
        // 確定save有service被呼叫
        then(userRepository).should().save(any(User.class));
        // 分組斷言
        assertAll("userService return dto",
                () -> assertEquals("TestAccount", user.getAccount(), "account not equal"),
                () -> assertEquals("12341234", user.getPassword()),
                () -> assertEquals("Hello", user.getName())
        );
    }

    @Test
    void loginSuccess() throws Exception {
        // given
        given(userRepository.getUserByAccountAndPassword(anyString(), anyString())).willReturn(Optional.of(user));

        // when
        userService.login("TestAccount", "12341234");

        // then
        // 判斷userRepository只被呼叫一次
        then(userRepository).should(times(1)).getUserByAccountAndPassword(any(), any());
    }

    @Test
    void loginException() {
        // given
        given(userRepository.getUserByAccountAndPassword(any(), any())).willReturn(Optional.empty());

        // 判斷是否拋出Exception
        assertThrows(Exception.class, () -> {
            userService.login("ErrorAccount", "1234");
        });
    }

    @Test
    void users() {

    }
}