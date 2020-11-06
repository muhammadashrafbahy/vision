package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class userAlreadyExist extends RuntimeException {

    private static final String errorNumber ="APP1-USER-ERROR-002";

    private  int userID ;

    public userAlreadyExist(int userID) {
        super(String.format("the user whose id is %s is already exist ",userID));
        this.userID = userID;
    }

    public  int getUserID() {
        return this.userID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
