package wei.springframework.test.sample.ui.rest.model;

import lombok.Data;

import javax.validation.constraints.Email;

/**
 * RegisterRequest.
 * TODO
 * 2019-06-16 17:38
 *
 * @author wei
 * @version 1.0.0
 **/
@Data
public class RegisterRequest {

    @Email
    private String account;

    private String password;

    private String name;

}
