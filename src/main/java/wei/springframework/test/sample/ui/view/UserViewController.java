package wei.springframework.test.sample.ui.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wei.springframework.test.sample.service.UserService;
import wei.springframework.test.sample.ui.rest.model.LoginRequest;
import wei.springframework.test.sample.ui.rest.model.RegisterRequest;
import wei.springframework.test.sample.ui.rest.model.UserDto;

import javax.validation.Valid;

/**
 * UserController.
 * TODO
 * 2019-06-21 05:55
 *
 * @author wei
 * @version 1.0.0
 **/
@Controller
@RequestMapping("/v1/users")
public class UserViewController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@Valid RegisterRequest request, Model model) {
        UserDto dto = userService.register(request.getAccount(), request.getPassword(), request.getName());

        model.addAttribute("id", dto.getId());
        model.addAttribute("account", dto.getAccount());
        model.addAttribute("name", dto.getName());
        return "view/register";
    }

    @PostMapping("/login")
    public String login(LoginRequest request, Model model) throws Exception {
        UserDto dto = userService.login(request.getAccount(), request.getPassword());

        model.addAttribute("id", dto.getId());
        model.addAttribute("account", dto.getAccount());
        model.addAttribute("name", dto.getName());
        return "view/login";
    }

}
