package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class ordersService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private ordersRepository ordersRepository;
    private clientService clientService ;
    @Autowired
    public ordersService(ordersRepository ordersRepository ,clientService clientService) {
        this.ordersRepository = ordersRepository;
        this.clientService = clientService;
    }

    /**
     * create new orders for client in the database
     * @param newOrders  the payload of the orders
     * @param clientID the id of the client
     */
    public void createAnOrdersForClient(int clientID , orders newOrders){

        this.ordersRepository.save(newOrders);
        client client = this.clientService.getClientByID(clientID);
        List<orders> clOrders = client.getOrclient_orders();
        clOrders.add(newOrders);
        client.setOrclient_orders(clOrders);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * check If Product In orders State
     * @param productID the id of the product
     * @return  exist or not
     */
    public boolean checkIfProductInorders(int productID ){
        orders orders = this.ordersRepository.findByProductID(productID);
        if (orders ==  null){
            return false;
        }
        else {

            return true;
        }
    }
    /**
     * return list of orders for given client according to clientID
     * @param clientID the id of the client
     * @return  list of orders for given client
     */
    public List<orders> getOrdersForClient(int clientID ){
        return this.clientService.getClientByID(clientID).getOrclient_orders();
    }
    /**
     * return list of open orders for given client according to clientID
     * @param clientID the id of the client
     * @return  list of orders for given client
     */
    public List<orders> getOpenOrdersForClient(int clientID ){
        List<orders> before =this.clientService.getClientByID(clientID).getOrclient_orders();
        List<orders> after = new ArrayList<>();
        for (orders o: before) {
            if (o.isState()){
                after.add(o);
            }
        }
        return after;
    }

    /**
     * return list of closed orders for given client according to clientID
     * @param clientID the id of the client
     * @return  list of orders for given client
     */
    public List<orders> getClosedOrdersForClient(int clientID ){
        List<orders> before =this.clientService.getClientByID(clientID).getOrclient_orders();
        List<orders> after = new ArrayList<>();
        for (orders o: before) {
            if (o.isState()==false){
                after.add(o);
            }
        }
        return after;  }

    /**
     * return  orders for given id
     * @param ordersID the id of the client
     * @return  orders
     */
    public orders getOrdersByID(int ordersID ){
        return this.ordersRepository.findById(ordersID).orElse(null);
    }

    /**
     * update orders data in  the database according to given id
     * @param  ordersID the id of orders
     * @param  newOrders the payload of the orders to update in database
     */
    public void updateOrders(int ordersID , orders newOrders ){
        orders oldOrders = this.ordersRepository.findById(ordersID).orElse(null);
        newOrders.setOrdersID(ordersID);
        modelMapper.map(newOrders,oldOrders);
        this.ordersRepository.save(oldOrders);

    }
    /**
     * update State of orders in  the database according to given id
     * @param  ordersID the id of orders
     * @param  state true of false
     */
    public void updateOrdersForConfirm(int ordersID , boolean state ){
        orders oldOrders = this.ordersRepository.findById(ordersID).orElse(null);
        oldOrders.setState(state);
        this.ordersRepository.save(oldOrders);

    }
    /**
     * update deliverState of orders data in  the database according to given id
     * @param  ordersID the id of orders
     * @param  deliverState track the orders
     */
    public void trackTheOrders(int ordersID , String deliverState ){
        orders oldOrders = this.ordersRepository.findById(ordersID).orElse(null);
        oldOrders.setDeliverState(deliverState);
        this.ordersRepository.save(oldOrders);

    }
    /**
     * delete orders data in  the database according to given id
     * @param  ordersID the id of orders
     */
    public void deleteOrders(int ordersID ) {
        this.ordersRepository.deleteById(ordersID);
    }

}

