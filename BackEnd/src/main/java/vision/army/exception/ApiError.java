package vision.army.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ApiError {

    @JsonProperty("errorNumber")
    private final String errorNumber;

    @JsonProperty("errorMessage")
    private final String errorMessage;


    public ApiError(String errorMessage, String errorNumber) {
        this.errorMessage = errorMessage;
        this.errorNumber = errorNumber;
         }


    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorNumber() {
        return errorNumber;
    }
}
