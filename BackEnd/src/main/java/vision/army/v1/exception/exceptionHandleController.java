package vision.army.v1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vision.army.exception.*;
import vision.army.v1.ApiResource.ApiResourceError;

import org.springframework.security.core.AuthenticationException;
import java.util.HashMap;

@ControllerAdvice(annotations = RestController.class)
public class exceptionHandleController extends ResponseEntityExceptionHandler {
private Logger logger = LoggerFactory.getLogger(exceptionHandleController.class);


    @RequestMapping("/errors-directory/{errorReference}")
    public ResponseEntity getError(@PathVariable("errorReference") String errorReference){
        logger.error(errorReference);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(userAlreadyExist.class)
    public ResponseEntity<ApiResourceError> userAlreadyExist(final userAlreadyExist userAlreadyExist) {
        // print the error message
            this.logger.error(String.format("Error ==> %s , %s ",userAlreadyExist.getErrorNumber(),userAlreadyExist.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(userAlreadyExist.getMessage(), userAlreadyExist.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.FORBIDDEN);

    }

    @ExceptionHandler(userNotFound.class)
    public ResponseEntity<ApiResourceError> userNotFound(final userNotFound userNotFound) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ",userNotFound.getErrorNumber(),userNotFound.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(userNotFound.getMessage(), userNotFound.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(productNotFound.class)
    public ResponseEntity<ApiResourceError> productNotFound(final productNotFound productNotFound) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ",productNotFound.getErrorNumber(),productNotFound.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(productNotFound.getMessage(), productNotFound.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(productIsInSale.class)
    public ResponseEntity<ApiResourceError> productIsInSale(final productIsInSale productIsInSale) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ",productIsInSale.getErrorNumber(),productIsInSale.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(productIsInSale.getMessage(), productIsInSale.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.FORBIDDEN);

    }

    @ExceptionHandler(clientNotFound.class)
    public ResponseEntity<ApiResourceError> clientNotFound(final clientNotFound clientNotFound) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ",clientNotFound.getErrorNumber(),clientNotFound.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(clientNotFound.getMessage(), clientNotFound.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(clientAlreadyExist.class)
    public ResponseEntity<ApiResourceError> clientAlreadyExist(final clientAlreadyExist clientAlreadyExist) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ",clientAlreadyExist.getErrorNumber(),clientAlreadyExist.getMessage()));
        // make ApiErrorResource for error message

        ApiError apiError = new ApiError(clientAlreadyExist.getMessage(), clientAlreadyExist.getErrorNumber());
        return    new ResponseEntity<>(new ApiResourceError(apiError), HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResourceError> AuthException(final AuthenticationException authenticationException) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ","authenticate failed",authenticationException.getMessage()));

        ApiError apiError = new ApiError(authenticationException.getMessage(),"authenticate failed");
        return new ResponseEntity<>(new ApiResourceError(apiError),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResourceError> UsernameNotFoundException(final UsernameNotFoundException UsernameNotFoundException) {
        // print the error message
        this.logger.error(String.format("Error ==> %s , %s ","authenticate failed",UsernameNotFoundException.getMessage()));

        ApiError apiError = new ApiError(UsernameNotFoundException.getMessage(),"authenticate failed");
        return new ResponseEntity<>(new ApiResourceError(apiError),HttpStatus.UNAUTHORIZED);
    }
    }
