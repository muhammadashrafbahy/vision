package vision.army.v1.ApiResource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.exception.ApiError;
import vision.army.v1.exception.exceptionHandleController;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResourceError extends RepresentationModel {
    @JsonProperty("apiError")
    public ApiError apiError ;

    public  ApiResourceError(ApiError apiError){
        this.apiError=apiError;

        String errorNumber =this.apiError.getErrorNumber();

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder
                .methodOn(exceptionHandleController.class , errorNumber).getError(errorNumber)).withSelfRel());

    }


}
