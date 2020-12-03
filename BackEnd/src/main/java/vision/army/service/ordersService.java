package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
     * return list of all orders
     * @return  list of orders
     */
    public List<orders> getAllOrders( ){
        return this.ordersRepository.findAll();
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
     * return list of  orders by state for given client according to clientID
     * @param clientID the id of the client
     * @param State the State of the order
     * @return  list of orders for given client
     */
    public List<orders> getOrdersByStateForClient(int clientID ,String State ){
        List<orders> before =this.clientService.getClientByID(clientID).getOrclient_orders();
        List<orders> after = new ArrayList<>();
        for (orders o: before) {
            if (o.getState().equals(State)){
                after.add(o);
            }
        }
        return after;
    }

    /**
     * return list of  orders by state
     * @param state the State of the order
     * @return  list of orders
     */
    public List<orders> getOrdersByState(String state ){
      return this.ordersRepository.findAllByState(state);
    }

    /**
     * return list of  orders by deliveredDate
     * @param deliveredDate the date of the deliver
     * @return  list of orders
     */
    public List<orders> getOrdersByDeliveredDate(Date deliveredDate ){
        return this.ordersRepository.findAllByDeliveredDate(deliveredDate);
    }

    /**
     * return list of  orders by orderDate
     * @param date the date of the order
     * @return  list of orders
     */
    public List<orders> getOrdersByOrderDate(Date date ){
        return this.ordersRepository.findAllByOrderDate(date);
    }

    /**
     * return list of  orders by price range
     * @param price1
     * @param price2
     * @return  list of orders
     */
    public List<orders> getOrdersByPriceRang(int price1 , int price2 ){
        return this.ordersRepository.findAllByDeliverPriceBetween(price1,price2);
    }

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
    public void updateOrdersState(int ordersID , String state ){
        orders oldOrders = this.ordersRepository.findById(ordersID).orElse(null);
        oldOrders.setState(state);
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

