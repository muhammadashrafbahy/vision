package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class favouriteService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private favouriteRepository favouriteRepository;
    private clientService clientService ;
    @Autowired
    public favouriteService(favouriteRepository favouriteRepository ,clientService clientService) {
        this.favouriteRepository = favouriteRepository;
        this.clientService = clientService;
    }

    /**
     * create new favourite for client in the database
     * @param newFavourite  the payload of the favourite
     * @param clientID the id of the client
     */
    public void createAnFavouriteForClient(int clientID , favourite newFavourite){

        this.favouriteRepository.save(newFavourite);
        client client = this.clientService.getClientByID(clientID);
        List<favourite> clFavourite = client.getFclient_favourite();
        clFavourite.add(newFavourite);
        client.setFclient_favourite(clFavourite);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * return list of favourite for given client according to clientID
     * @param clientID the id of the client
     * @return  list of favourite for given client
     */
    public List<favourite> getFavouriteForClient(int clientID ){
        return this.clientService.getClientByID(clientID).getFclient_favourite();
    }

    /**
     * return  favourite for given id
     * @param favouriteID the id of the client
     * @return  favourite
     */
    public favourite getFavouriteByID(int favouriteID ){
        return this.favouriteRepository.findById(favouriteID).orElse(null);
    }

    /**
     * update favourite data in  the database according to given id
     * @param  favouriteID the id of favourite
     * @param  newFavourite the payload of the favourite to update in database
     */
    public void updateFavourite(int favouriteID , favourite newFavourite ){
        favourite oldFavourite = this.favouriteRepository.findById(favouriteID).orElse(null);
        newFavourite.setFavID(favouriteID);
        modelMapper.map(newFavourite,oldFavourite);
        this.favouriteRepository.save(oldFavourite);

    }

    /**
     * delete favourite data in  the database according to given id
     * @param  favouriteID the id of favourite
     */
    public void deleteFavourite(int favouriteID ) {
        this.favouriteRepository.deleteById(favouriteID);
    }

}

