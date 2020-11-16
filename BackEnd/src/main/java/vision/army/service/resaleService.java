package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class resaleService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private resaleRepository resaleRepository;
    private clientService clientService ;
    @Autowired
    public resaleService(resaleRepository resaleRepository ,clientService clientService) {
        this.resaleRepository = resaleRepository;
        this.clientService = clientService;
    }

    /**
     * create new resale for client in the database
     * @param newResale  the payload of the resale
     * @param clientID the id of the client
     */
    public void createAnResaleForClient(int clientID , resale newResale){

        this.resaleRepository.save(newResale);
        client client = this.clientService.getClientByID(clientID);
        List<resale> clResale = client.getRclient_resale();
        clResale.add(newResale);
        client.setRclient_resale(clResale);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * return list of resale for given client according to clientID
     * @param clientID the id of the client
     * @return  list of resale for given client
     */
    public List<resale> getResaleForClient(int clientID ){
        return this.clientService.getClientByID(clientID).getRclient_resale();
    }

    /**
     * return  resale for given id
     * @param resaleID the id of the resale
     * @return  resale
     */
    public resale getResaleByID(int resaleID ){

        return this.resaleRepository.findById(resaleID).orElse(null);
    }
    /**
     * return  list of resales resale for given data
     * @param resaleDate the date of the resale
     * @return  list of resales
     */
    public List<resale> getResaleByDate(Date resaleDate ){

        return this.resaleRepository.findAllByReSaleDate(resaleDate);
    }
    /**
     * return  list of resales resale for given confirmDate
     * @param confirmDate the date of the resale
     * @return  list of resales
     */
    public List<resale> getResaleByConfirmDate(Date confirmDate ){

        return this.resaleRepository.findAllByConfirmDate(confirmDate);
    }
    /**
     * return  list of resales resale for given confirm
     * @param confirm the confirm of the resale
     * @return  list of resales
     */
    public List<resale> getResaleByConfirm(boolean confirm ){

        return this.resaleRepository.findAllByConfirm(confirm);
    }

    /**
     * update resale data in  the database according to given id
     * @param  resaleID the id of resale
     * @param  newResale the payload of the resale to update in database
     */
    public void updateResale(int resaleID , resale newResale ){
        resale oldResale = this.resaleRepository.findById(resaleID).orElse(null);
        newResale.setReSaleID(resaleID);
        modelMapper.map(newResale,oldResale);
        this.resaleRepository.save(oldResale);

    }
    /**
     * update confirmed resale data in  the database according to given id
     * @param  resaleID the id of resale
     * @param  confirmDate the data of confirm
     * @param  confirm true of false
     */
    public void updateResaleForConfirm(int resaleID , boolean confirm , Date confirmDate){
        resale oldResale = this.resaleRepository.findById(resaleID).orElse(null);
        oldResale.setConfirm(confirm);
        oldResale.setConfirmDate(confirmDate);
        this.resaleRepository.save(oldResale);

    }
    /**
     * delete resale data in  the database according to given id
     * @param  resaleID the id of resale
     */
    public void deleteResale(int resaleID ) {
        this.resaleRepository.deleteById(resaleID);
    }

}
