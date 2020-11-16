package vision.army.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class clientNotFound extends RuntimeException {
    private static final String errorNumber ="APP1-CLIENT-ERROR-001";

    private  int clientID ;

    public clientNotFound(int userID) {
        super(String.format("the client with id is %s is not found",userID));
        this.clientID = clientID;
    }

    public  int getClientID() {
        return this.clientID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }

}
