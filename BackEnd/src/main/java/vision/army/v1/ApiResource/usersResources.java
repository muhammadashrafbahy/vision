package vision.army.v1.ApiResource;


import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.v1.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;

import java.util.List;

public class usersResources  extends RepresentationModel{
    private List<user> userList ;

    public usersResources(List<user> userList) {
        this.userList = userList;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).getAllUsers())
                .withSelfRel());
    }




    public List<user> getUsers(){
        return this.userList;

    }
}
