package wei.springframework.test.sample.ui.rest.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDto.
 * TODO
 * 2019-06-19 21:10
 *
 * @author wei
 * @version 1.0.0
 **/
@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String account;

    private String name;

    @Builder
    public UserDto(Long id, String account, String name) {
        this.id = id;
        this.account = account;
        this.name = name;
    }

}
