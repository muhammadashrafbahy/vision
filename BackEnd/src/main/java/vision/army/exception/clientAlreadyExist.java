package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class clientAlreadyExist extends RuntimeException {
    private static final String errorNumber ="APP1-CLIENT-ERROR-002";

    private  String clientName ;

    public clientAlreadyExist(String clientName) {
        super(String.format("the client whose name is %s is already exist ",clientName));
        this.clientName = clientName;
    }

    public  String getClientName() {
        return this.clientName ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
