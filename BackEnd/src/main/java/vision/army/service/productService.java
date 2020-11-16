package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.service.validation.*;

@Service
public class productService {
    private final ModelMapper modelMapper = new ModelMapper();
    private productRepository productRepository;
    private productValidator productValidator;
    @Autowired

    public productService(productRepository productRepository, productValidator productValidator) {
        this.productRepository = productRepository;
        this.productValidator = productValidator;
    }
    /**
     * create new product in the database
     * @param newProduct  the payload of the product
     */
    public void createAnProduct(product newProduct){
        this.productRepository.save(newProduct);
    }

    /**
     * update product data in the database according to given id
     * @param newProduct  the payload of the product to update
     * @param productID  the id of the product
     */
    public void updateAnProduct(product newProduct, int productID){
        product oldProduct = this.productValidator.getValidProduct(productID);
        newProduct.setProductID(productID);
        modelMapper.map(newProduct,oldProduct);
        this.productRepository.save(oldProduct);

    }
    /**
     * delete product data in  the database according to given id
     * @param  productID the id of product
     */
    public void deleteProduct(int productID ) {
        if (this.productValidator.checkIfProductInOrderSale(productID)==false){
            this.productRepository.deleteById(productID);
        }
    }
    /**
     * list of all products
     * @return list of all products
     */
    public List<product> getAllProducts() {
        return this.productRepository.findAll();
    }
    /**
     * list of  all most sales products
     * @return list of all products
     */
    public List<product> getAllMostSalesProduct() {
        return this.productRepository.findAllBySalesNoIsNotNullOrderBySalesNoDesc();
    }
    /**
     * list of  all most rated products
     * @return list of all products
     */
    public List<product> getAllMostRatedProduct() {
        return this.productRepository.findAllBySalesNoIsNotNullOrderBySalesNoDesc();
    }
    /**
     * get product data from the database according to given id
     * @param  productID the ID of the product
     * @return product data
     */
    public product getProductByID(int productID) {
        return this.productValidator.getValidProduct(productID);
    }
    /**
     * list of all products according to brandID
     * @param  brandID the ID of the brand
     * @return list of all products
     */
    public List<product> getAllProductsByBrand(int brandID) {
        return this.productRepository.findAllByBrandID(brandID);
    }
    /**
     * list of all products according to product type id
     * @param  prdTypeID the ID of the product type
     * @return list of all products
     */
    public List<product> getAllProductsByProductType(int prdTypeID) {
        return this.productRepository.findAllByPrdTypeID(prdTypeID);
    }
    /**
     * list of all products according to product type main id
     * @param  prdTypeMainID the ID of the product type
     * @return list of all products
     */
    public List<product> getAllProductsByProductTypeMain(int prdTypeMainID) {
        return this.productRepository.findAllByPrdTypeMainID(prdTypeMainID);
    }
    /**
     * list of all products according to product name
     * @param  prodName the name of the product
     * @return list of all products
     */
    public List<product> getAllProductsByName(String prodName) {
        return this.productRepository.findAllByProdNameLike(prodName);
    }

    /**
     * list of all products according to price Range
     * @param  firstPrice the price from
     * @param  secondPrice the price to
     * @return list of all products
     */
    public List<product> getAllProductsByPriceRang(int firstPrice , int  secondPrice) {
        return this.productRepository.findALlByProdPriceBetween( firstPrice, secondPrice);
    }
}
