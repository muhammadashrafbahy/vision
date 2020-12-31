package vision.army.reprositery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import vision.army.entity.product;

import java.util.List;

public interface productRepository extends PagingAndSortingRepository<product, Integer> {
//    List<product> findAll();
     List<product> findAllByPrdTypeID (int prdTypeID, Pageable pageable);
    List<product> findAllByPrdTypeMainID (int prdTypeMainID, Pageable pageable);
    List<product> findAllByBrandID (int brand, Pageable pageable);
    List<product> findAllByProdNameLike (String prodName, Pageable pageable);
    List<product> findALlByProdPriceBetween (int firstPrice , int secondPrice, Pageable pageable);
    List<product> findAllBySalesNoIsNotNullOrderBySalesNoDesc ( Pageable pageable);
//    List<product> findAllByRateIsNotNullOrderByRateDesc ();
}
