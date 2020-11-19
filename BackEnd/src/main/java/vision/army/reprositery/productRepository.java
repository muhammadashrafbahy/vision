package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.product;

import java.util.List;

public interface productRepository extends JpaRepository<product, Integer> {
     List<product> findAllByPrdTypeID (int prdTypeID);
    List<product> findAllByPrdTypeMainID (int prdTypeMainID);
    List<product> findAllByBrandID (int brand);
    List<product> findAllByProdNameLike (String prodName);
    List<product> findALlByProdPriceBetween (int firstPrice , int secondPrice);
    List<product> findAllBySalesNoIsNotNullOrderBySalesNoDesc ();
//    List<product> findAllByRateIsNotNullOrderByRateDesc ();
}
