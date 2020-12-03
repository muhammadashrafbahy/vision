package vision.army.v1.ApiResource;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import vision.army.entity.product;
import vision.army.v1.vision;

import java.util.List;

public class productsResources  extends RepresentationModel {
    private List<product> productList ;

    public productsResources(List<product> productList) {
        this.productList = productList;

        this.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(vision.class).getAllProducts())
                .withSelfRel());
    }




    public List<product> getProducts(){
        return this.productList;

    }}