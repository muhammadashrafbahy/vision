package vision.army.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;

@Service
public class prodTypeService {
    private final ModelMapper modelMapper = new ModelMapper();
    private prodTypeRepository prodTypeRepository;

    @Autowired

    public prodTypeService(prodTypeRepository prodTypeRepository) {
        this.prodTypeRepository = prodTypeRepository;
    }

    /**
     * create new productType  in the database
     * @param newProductType  the payload of the productType
     */
    public void createAnProdType(productType newProductType){

        this.prodTypeRepository.save(newProductType);
    }

    /**
     * return  productType for given id
     * @param productTypeID the id of the productType
     * @return  productType
     */
    public productType getProductTypeByID(int productTypeID ){
        return this.prodTypeRepository.findById(productTypeID).orElse(null);
    }

    /**
     * return  list of all productTypes
     * @return  list of all productTypes
     */
    public List<productType> getAllProductTypes(){
        return this.prodTypeRepository.findAll();
    }

    /**
     * update productType data in  the database according to given id
     * @param  productTypeID the id of productType
     * @param  newProductType the payload of the productType to update in database
     */
    public void updateProductType(int productTypeID , productType newProductType ){
        productType oldProductType = this.prodTypeRepository.findById(productTypeID).orElse(null);
        newProductType.setPrdTypeID(productTypeID);
        modelMapper.map(newProductType , oldProductType);
        this.prodTypeRepository.save(oldProductType);

    }
    /**
     * delete productType data in  the database according to given id
     * @param  productTypeID the id of productType
     */
    public void deleteProductType(int productTypeID ) {
        this.prodTypeRepository.deleteById(productTypeID);
    }

}
