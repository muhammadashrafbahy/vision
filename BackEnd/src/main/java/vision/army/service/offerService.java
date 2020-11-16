package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;

@Service
public class offerService {
    private final ModelMapper modelMapper = new ModelMapper();
    private offerRepository offerRepository;

    @Autowired

    public offerService(offerRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    /**
     * create new offer  in the database
     * @param newOffer  the payload of the offer
     */
    public void createOffer(offer newOffer){

        this.offerRepository.save(newOffer);
    }

    /**
     * return  offer for given id
     * @param offerID the id of the offer
     * @return  offer
     */
    public offer getOfferByID(int offerID ){
        return this.offerRepository.findById(offerID).orElse(null);
    }

    /**
     * return  list of all offers
     * @return  list of all offers
     */
    public List<offer> getAllOffers(){
        return this.offerRepository.findAll();
    }

    /**
     * update offer data in  the database according to given id
     * @param  offerID the id of offer
     * @param  newOffer the payload of the offer to update in database
     */
    public void updateOffer(int offerID , offer newOffer ){
        offer oldOffer = this.offerRepository.findById(offerID).orElse(null);
        newOffer.setOfferID(offerID);
        modelMapper.map(newOffer , oldOffer);
        this.offerRepository.save(oldOffer);

    }
    /**
     * delete offer data in  the database according to given id
     * @param  offerID the id of offer
     */
    public void deleteOffer(int offerID ) {
        this.offerRepository.deleteById(offerID);
    }

}
