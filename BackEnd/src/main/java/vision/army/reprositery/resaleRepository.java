package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.resale;

import java.util.Date;
import java.util.List;

public interface resaleRepository extends JpaRepository<resale, Integer> {

    List<resale> findAllByReSaleDate (Date resaleDate);
    List<resale> findAllByConfirm (boolean confirm);
    List<resale>  findAllByConfirmDate (Date confirmDate);

}
