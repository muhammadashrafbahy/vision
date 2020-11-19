package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.orders;

public interface ordersRepository extends JpaRepository<orders, Integer > {

    orders findByProductID (int productID);
}
