package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.favourite;

public interface favouriteRepository extends JpaRepository<favourite,Integer> {
}
