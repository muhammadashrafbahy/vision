package vision.army.v1.ApiResource;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.entity.client;
import vision.army.v1.vision;

public class clientResource extends RepresentationModel {

    private client client ;

    public clientResource(client client) {
        this.client = client;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).
                getClientByID(this.client.getClientID())).withSelfRel());
    }

    public client getClient(){
        return this.client;

    }

}
