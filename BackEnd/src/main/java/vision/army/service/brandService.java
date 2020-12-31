package vision.army.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;

@Service
public class brandService  {

    private final ModelMapper modelMapper = new ModelMapper();
    private brandRepository brandRepository;

    @Autowired

    public brandService(brandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /**
     * create new brand  in the database
     * @param newBrand  the payload of the brand
     */
    public void createBrand(brand newBrand){

            this.brandRepository.save(newBrand);
    }

    /**
     * return  brand for given id
     * @param brandID the id of the brand
     * @return  brand
     */
    public brand getBrandByID(int brandID ){
        return this.brandRepository.findById(brandID).orElse(null);
    }

    /**
     * return  list of all brands
     * @return  list of all brands
     */
    public List<brand> getAllBrands(){
        return this.brandRepository.findAll();
    }

    /**
     * update brand data in  the database according to given id
     * @param  brandID the id of brand
     * @param  newBrand the payload of the brand to update in database
     */
    public void updateBrand(int brandID , brand newBrand ){
        brand oldBrand = this.brandRepository.findById(brandID).orElse(null);
        newBrand.setBrandID(brandID);
        modelMapper.map(newBrand , oldBrand);
        this.brandRepository.save(oldBrand);

    }
    /**
     * delete brand data in  the database according to given id
     * @param  brandID the id of brand
     */
    public void deleteBrand(int brandID ) {
        this.brandRepository.deleteById(brandID);
    }

    public void deleteAllBrands() {this.brandRepository.deleteAll();
    }
}
