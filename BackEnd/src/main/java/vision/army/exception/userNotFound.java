package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFound extends RuntimeException {

    private static final String errorNumber ="APP1-USER-ERROR-001";

    private  int userID ;

    public userNotFound(int userID) {
        super(String.format("the user whose id is %s is not found",userID));
        this.userID = userID;
    }

    public  int getuserID() {
        return this.userID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
