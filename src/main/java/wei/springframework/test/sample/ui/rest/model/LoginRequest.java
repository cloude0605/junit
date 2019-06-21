package wei.springframework.test.sample.ui.rest.model;

import lombok.Data;

/**
 * LoginRequest.
 * TODO
 * 2019-06-16 17:39
 *
 * @author wei
 * @version 1.0.0
 **/
@Data
public class LoginRequest {

    private String account;

    private String password;
}
