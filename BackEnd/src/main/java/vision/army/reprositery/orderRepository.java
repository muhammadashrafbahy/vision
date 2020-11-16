package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.order;

public interface orderRepository extends JpaRepository<order, Integer > {

    order findByProductID (int productID);
}
