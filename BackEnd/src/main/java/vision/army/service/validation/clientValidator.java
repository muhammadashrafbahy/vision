package vision.army.service.validation;

import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class clientValidator {
    private clientRepository clientRepository;

    @Autowired
    public clientValidator(clientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * returns a valid client the database
     * @param clientID the given client
     * @return the client object
     */

    public client getValidClient(int clientID) {

        client client = this.clientRepository.findById(clientID).orElse(null);
        if (client == null){

            throw new clientNotFound(clientID);
        }else {

            return client;
        }
    }

    /**
     * return true if  client already exist in the database
     * @param clientName the given client
     * @return true or false
     */

    public boolean checkExistOfClientForCreation(String clientName) {
        client client = this.clientRepository.findByClientName(clientName);
        if (client == null){

            return false;
        }else {
            throw  new clientAlreadyExist(clientName);

        }
    }
}
