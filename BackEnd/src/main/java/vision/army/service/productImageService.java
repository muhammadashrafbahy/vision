package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;

@Service
public class productImageService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private productImageRepository productImageRepository;
    private productService productService ;
    @Autowired
    public productImageService(productImageRepository productImageRepository ,productService productService) {
        this.productImageRepository = productImageRepository;
        this.productService = productService;
    }

    /**
     * create new productImage for product in the database
     * @param newProductImage  the payload of the productImage
     * @param productID the id of the product
     */
    public void createAnProductImageForProduct(int productID , productImage newProductImage){

        this.productImageRepository.save(newProductImage);
        product product = this.productService.getProductByID(productID);
        List<productImage> clProductImage = product.getProductImages();
        clProductImage.add(newProductImage);
        product.setProductImages(clProductImage);
        this.productService.updateAnProduct(product ,productID);

    }
    /**
     * return list of productImage for given product according to productID
     * @param productID the id of the product
     * @return  list of productImage for given product
     */
    public List<productImage> getProductImageForProduct(int productID ){
        return this.productService.getProductByID(productID).getProductImages();
    }

    /**
     * return  productImage for given id
     * @param productImageID the id of the product
     * @return  productImage
     */
    public productImage getProductImageByID(int productImageID ){
        return this.productImageRepository.findById(productImageID).orElse(null);
    }

    /**
     * update productImage data in  the database according to given id
     * @param  productImageID the id of productImage
     * @param  newProductImage the payload of the productImage to update in database
     */
    public void updateProductImage(int productImageID , productImage newProductImage ){
        productImage oldProductImage = this.productImageRepository.findById(productImageID).orElse(null);
        newProductImage.setPrdImID(productImageID);
        modelMapper.map(newProductImage,oldProductImage);
        this.productImageRepository.save(oldProductImage);

    }

    /**
     * delete productImage data in  the database according to given id
     * @param  productImageID the id of productImage
     */
    public void deleteProductImage(int productImageID ) {
        this.productImageRepository.deleteById(productImageID);
    }

}


