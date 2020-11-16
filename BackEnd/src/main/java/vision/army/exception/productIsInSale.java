package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class productIsInSale extends RuntimeException {
    private static final String errorNumber ="APP1-PRODUCT-ERROR-002";

    private  int productID ;

    public productIsInSale(int userID) {
        super(String.format("the product with id is %s is already in order process",userID));
        this.productID = productID;
    }

    public  int getProductID() {
        return this.productID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }

}
