package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.user;

import java.util.Optional;

public interface userRepository extends JpaRepository<user, Integer> {

    Optional<user> findByuserName(String userName);
}
