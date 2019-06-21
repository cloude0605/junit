package wei.springframework.test.sample.persistence.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User.
 * 2019-06-16 17:30
 *
 * @author wei
 * @version 1.0.0
 **/
@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String account;
    private String password;
    private String name;

    @Builder
    public User(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }

}
