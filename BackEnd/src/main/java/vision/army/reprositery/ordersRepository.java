package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.orders;

import java.util.Date;
import java.util.List;

public interface ordersRepository extends JpaRepository<orders, Integer > {

    orders findByProductID (int productID);
    List<orders> findAllByDeliveredDate (Date deliveredDate);
    List<orders> findAllByOrderDate (Date orderDate);
    List<orders> findAllByState (String State);
    List<orders> findAllByDeliverPriceBetween (int price1 , int price2);
}
