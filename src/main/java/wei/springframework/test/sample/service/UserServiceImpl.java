package wei.springframework.test.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.persistence.respository.UserRepository;
import wei.springframework.test.sample.ui.rest.mappers.UserMapper;
import wei.springframework.test.sample.ui.rest.model.UserDto;
import wei.springframework.test.sample.ui.rest.model.UserPagedList;

import java.util.stream.Collectors;

/**
 * UserServiceImpl.
 * TODO
 * 2019-06-16 17:33
 *
 * @author wei
 * @version 1.0.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto register(String account, String password, String name) {
        User user = User
                .builder()
                .account(account)
                .password(password)
                .name(name)
                .build();

        userRepository.save(user);

        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto login(String account, String password) throws Exception {

        User user = userRepository.getUserByAccountAndPassword(account, password).orElseThrow(() ->
                new Exception("User Not Found")
        );

        return userMapper.userToUserDto(user);
    }

    @Override
    public UserPagedList users(String name, Integer pageNumber, Integer pageSize) {

        UserPagedList userPagedList;
        Page<User> userPage;

        userPage = userRepository.findAllByNameContaining(name, PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "account"));

        userPagedList = new UserPagedList(userPage
                .getContent().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(userPage.getPageable().getPageNumber(),
                                userPage.getPageable().getPageSize()),
                userPage.getTotalElements());
        return userPagedList;
    }
}
