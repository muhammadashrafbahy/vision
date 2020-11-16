package vision.army.service.validation;

import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vision.army.service.orderService;

@Component
public class productValidator {
    private productRepository productRepository;
    private orderService orderService;
    @Autowired
    public productValidator(productRepository productRepository,orderService orderService) {
        this.orderService = orderService;
        this.productRepository = productRepository;
    }

    /**
     * returns a valid product the database
     * @param productID the given product
     * @return the product object
     */

    public product getValidProduct(int productID) {

        product product = this.productRepository.findById(productID).orElse(null);
        if (product == null){

            throw new productNotFound(productID);
        }else {

            return product;
        }
    }
    /**
     * returns a valid product the database
     * @param productID the given product
     * @return true or false
     */

    public boolean checkIfProductInOrderSale(int productID) {

     if (this.orderService.checkIfProductInOrder(productID)==true){
         throw new productIsInSale(productID);
     }else{return false;}
    }
}
