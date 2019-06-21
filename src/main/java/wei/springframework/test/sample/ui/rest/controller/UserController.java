package wei.springframework.test.sample.ui.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wei.springframework.test.sample.service.UserService;
import wei.springframework.test.sample.ui.rest.model.LoginRequest;
import wei.springframework.test.sample.ui.rest.model.RegisterRequest;
import wei.springframework.test.sample.ui.rest.model.UserDto;
import wei.springframework.test.sample.ui.rest.model.UserPagedList;

import javax.validation.Valid;

/**
 * UserController.
 * 2019-06-16 17:35
 *
 * @author wei
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/rest/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserPagedList> users(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "pageNumber") Integer pageNumber,
            @RequestParam(name = "pageSize") Integer pageSize
    ) {
        UserPagedList users = userService.users(name, pageNumber, pageSize);

        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequest request) {
        UserDto dto = userService.register(request.getAccount(), request.getPassword(), request.getName());
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) throws Exception {
        UserDto dto = userService.login(request.getAccount(), request.getPassword());

        return ResponseEntity.ok(dto);
    }

}
