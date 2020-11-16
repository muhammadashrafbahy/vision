package vision.army.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class userAlreadyExist extends RuntimeException {

    private static final String errorNumber ="APP1-USER-ERROR-002";

    private  String userName ;

    public userAlreadyExist(String userName) {
        super(String.format("the user whose  user_name is %s is already exist ",userName));
        this.userName = userName;
    }

    public  String getUserName() {
        return this.userName ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
