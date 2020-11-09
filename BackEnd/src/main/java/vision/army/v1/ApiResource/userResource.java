package vision.army.v1.ApiResource;


import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.v1.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;

import java.util.List;

public class userResource extends RepresentationModel{

    private user user ;

    public userResource(user user) {
        this.user = user;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).
                getUserDetails(this.user.getUserID())).withSelfRel());
    }

    public user getUser(){
        return this.user;

    }
}
