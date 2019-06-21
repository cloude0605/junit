package wei.springframework.test.sample.persistence.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wei.springframework.test.sample.persistence.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByAccountAndPassword(String account, String password);

    Page<User> findAllByNameContaining(String name, Pageable pageable);

}
