package wei.springframework.test.sample.service;

import org.springframework.data.domain.PageRequest;
import wei.springframework.test.sample.persistence.model.User;
import wei.springframework.test.sample.ui.rest.model.UserDto;
import wei.springframework.test.sample.ui.rest.model.UserPagedList;

import java.util.List;

/**
 * UserService.
 */
public interface UserService {

    /**
     * 註冊
     * @param account 帳號
     * @param password 密碼
     * @param name 名稱
     */
    UserDto register(String account, String password, String name);

    /**
     * 登入
     * @param account 帳號
     * @param password 密碼
     * @return 使用者
     */
    UserDto login(String account, String password) throws Exception;

    /**
     * 使用者清單
     * @return
     */
    UserPagedList users(String name, Integer pageNumber, Integer pageSize);
}
