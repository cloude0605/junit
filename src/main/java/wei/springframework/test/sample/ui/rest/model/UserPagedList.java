package wei.springframework.test.sample.ui.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import wei.springframework.test.sample.persistence.model.User;

import java.util.List;

/**
 * UserPagedList.
 * TODO
 * 2019-06-18 06:31
 *
 * @author wei
 * @version 1.0.0
 **/
public class UserPagedList extends PageImpl<UserDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public UserPagedList(
            @JsonProperty("content") List<UserDto> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("pageable") JsonNode pageable,
            @JsonProperty("last") boolean last,
            @JsonProperty("totalPages") int totalPages,
            @JsonProperty("sort") JsonNode sort,
            @JsonProperty("first") boolean first,
            @JsonProperty("numberOfElements") int numberOfElements
    ) {
        super(content, PageRequest.of(number, size), totalElements);
    }

    public UserPagedList(List<UserDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public UserPagedList(List<UserDto> content) {
        super(content);
    }
}
