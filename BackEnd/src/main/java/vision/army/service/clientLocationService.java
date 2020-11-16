package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class clientLocationService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private clientLocationRepository clientLocationRepository;
    private clientService clientService ;
    @Autowired
    public clientLocationService(clientLocationRepository clientLocationRepository ,clientService clientService) {
        this.clientLocationRepository = clientLocationRepository;
        this.clientService = clientService;
    }

    /**
     * create new clientLocation for client in the database
     * @param newClientLocation  the payload of the clientLocation
     * @param clientID the id of the client
     */
    public void createAnClientLocationForClient(int clientID , clientLocation newClientLocation){

        this.clientLocationRepository.save(newClientLocation);
        client client = this.clientService.getClientByID(clientID);
        List<clientLocation> clClientLocation = client.getAclient_location();
        clClientLocation.add(newClientLocation);
        client.setAclient_location(clClientLocation);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * return list of clientLocation for given client according to clientID
     * @param clientID the id of the client
     * @return  list of clientLocation for given client
     */
    public List<clientLocation> getClientLocationForClient(int clientID ){
        return this.clientService.getClientByID(clientID).getAclient_location();
    }

    /**
     * return  clientLocation for given id
     * @param clientLocationID the id of the client
     * @return  clientLocation
     */
    public clientLocation getClientLocationByID(int clientLocationID ){
        return this.clientLocationRepository.findById(clientLocationID).orElse(null);
    }

    /**
     * update clientLocation data in  the database according to given id
     * @param  clientLocationID the id of clientLocation
     * @param  newClientLocation the payload of the clientLocation to update in database
     */
    public void updateClientLocation(int clientLocationID , clientLocation newClientLocation ){
        clientLocation oldClientLocation = this.clientLocationRepository.findById(clientLocationID).orElse(null);
        newClientLocation.setClLocationID(clientLocationID);
        modelMapper.map(newClientLocation,oldClientLocation);
        this.clientLocationRepository.save(oldClientLocation);

    }

    /**
     * delete clientLocation data in  the database according to given id
     * @param  clientLocationID the id of clientLocation
     */
    public void deleteClientLocation(int clientLocationID ) {
        this.clientLocationRepository.deleteById(clientLocationID);
    }

}


