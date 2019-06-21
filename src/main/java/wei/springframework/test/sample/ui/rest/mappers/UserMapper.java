package wei.springframework.test.sample.ui.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.ui.rest.model.UserDto;

@Mapper(uses = DefaultMapper.class)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "account", source = "account"),
            @Mapping(target = "name", source = "name")
    })
    UserDto userToUserDto(User user);

}
