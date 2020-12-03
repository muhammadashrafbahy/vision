package vision.army.v1.ApiResource;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.entity.client;
import vision.army.v1.vision;

import java.util.List;

public class clientResources extends RepresentationModel {
    private List<client> clientList ;

    public clientResources(List<client> clientList) {
        this.clientList = clientList;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).getAllClients())
                .withSelfRel());
    }




    public List<client> getClients(){
        return this.clientList;

    }
}
