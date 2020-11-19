package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.service.validation.*;
@Service
public class clientService {
    private final ModelMapper modelMapper = new ModelMapper();
    private clientRepository clientRepository;
    private clientValidator clientValidator;
    private userService userService ;

    @Autowired
    public clientService(clientRepository clientRepository, clientValidator clientValidator ,userService userService) {
        this.clientRepository = clientRepository;
        this.clientValidator = clientValidator;
        this.userService = userService;
    }

    /**
     * create new client in the database
     * @param newClient  the payload of the client
     */
    public void createAnClient(client newClient){
        if (this.clientValidator.checkExistOfClientForCreation(newClient.getClientName())==false){


        user user = new user();
        user.setUserName(newClient.getClientName());
        user.setPassword(newClient.getClientPassword());
        user.setUserEmail(newClient.getClientEmail());
        user.setImage(newClient.getClientImage());
        this.userService.createAnUser(user);
        this.clientRepository.save(newClient);
        }

    }

    /**
     * return all  client from the database
     * @return  list of all clients in the database
     */
    public List<client> returnALLClient(){

        return this.clientRepository.findAll();
    }

    /**
     * return client data from  the database according to given id
     * @param  clientID the id of client
     * @return client
     */
    public client getClientByID(int clientID ){
        client oldClient = this.clientValidator.getValidClient(clientID);
        return oldClient;
    }
    /**
     * update client data in  the database according to given id
     * @param  clientID the id of client
     * @param  newClient the payload of the client to update in database
     */
    public void updateClient(int clientID , client newClient ){
            client oldClient = this.clientValidator.getValidClient(clientID);
            newClient.setClientID(clientID);
            modelMapper.map(newClient,oldClient);
            this.clientRepository.save(oldClient);

    }

    /**
     * delete client data in  the database according to given id
     * @param  clientID the id of client
     */
    public void deleteClient(int clientID ) {
        client client = this.clientValidator.getValidClient(clientID);
        if (client != null) {

            this.clientRepository.delete(client);
        }
    }
    /**
     * delete all clients in the database
     */
    public void deleteAllClients( ) {
        this.clientRepository.deleteAll();
    }


        /**
         * return client according to the client_name
         * @param  clientName the userName of the client
         * @return client the payload of the resulted client
         */
        public client getClientByName(String  clientName ){
            return this.clientRepository.findByClientName(clientName);

        }

    /**
     * return client according to the client_email
     * @param  clientEmail the email of the client
     * @return client the payload of the resulted client
     */
    public client getClientByEmail(String  clientEmail ){
        return this.clientRepository.findByClientEmail(clientEmail);

    }

    /**
     * return client according to the client_phone
     * @param  clientPhone the phone of the client
     * @return client the payload of the resulted client
     */
    public client getClientByPhone(String  clientPhone ){
        return this.clientRepository.findByPhone(clientPhone);

    }

    /**
     * return list of clients according to the gender
     * @param  gender the gender of the client
     * @return list of clients
     */
    public List<client> getClientsByGender(String  gender ){
        return this.clientRepository.findAllByGender(gender);

    }


}
