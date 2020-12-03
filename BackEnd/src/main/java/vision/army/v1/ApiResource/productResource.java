package vision.army.v1.ApiResource;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.entity.product;
import vision.army.v1.vision;

public class productResource extends RepresentationModel {
    private product product ;

    public productResource(product product) {
        this.product = product;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).
                getProductDetails(this.product.getProductID())).withSelfRel());
    }

    public product getProduct(){
        return this.product;

    }
}
