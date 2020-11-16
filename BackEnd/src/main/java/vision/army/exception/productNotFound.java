package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class productNotFound extends RuntimeException {
    private static final String errorNumber ="APP1-PRODUCT-ERROR-001";

    private  int productID ;

    public productNotFound(int userID) {
        super(String.format("the product with id is %s is not found",userID));
        this.productID = productID;
    }

    public  int getProductID() {
        return this.productID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }

}
