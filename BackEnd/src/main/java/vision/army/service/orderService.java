package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class orderService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private orderRepository orderRepository;
    private clientService clientService ;
    @Autowired
    public orderService(orderRepository orderRepository ,clientService clientService) {
        this.orderRepository = orderRepository;
        this.clientService = clientService;
    }

    /**
     * create new order for client in the database
     * @param newOrder  the payload of the order
     * @param clientID the id of the client
     */
    public void createAnOrderForClient(int clientID , order newOrder){

        this.orderRepository.save(newOrder);
        client client = this.clientService.getClientByID(clientID);
        List<order> clOrder = client.getOclient_order();
        clOrder.add(newOrder);
        client.setOclient_order(clOrder);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * check If Product In Order State
     * @param productID the id of the product
     * @return  exist or not
     */
    public boolean checkIfProductInOrder(int productID ){
        order order = this.orderRepository.findByProductID(productID);
        if (order ==  null){
            return false;
        }
        else {

            return true;
        }
    }
    /**
     * return list of order for given client according to clientID
     * @param clientID the id of the client
     * @return  list of order for given client
     */
    public List<order> getOrderForClient(int clientID ){
        return this.clientService.getClientByID(clientID).getOclient_order();
    }
    /**
     * return list of open order for given client according to clientID
     * @param clientID the id of the client
     * @return  list of order for given client
     */
    public List<order> getOpenOrderForClient(int clientID ){
        List<order> before =this.clientService.getClientByID(clientID).getOclient_order();
        List<order> after = new ArrayList<>();
        for (order o: before) {
            if (o.isState()){
                after.add(o);
            }
        }
        return after;
    }

    /**
     * return list of closed order for given client according to clientID
     * @param clientID the id of the client
     * @return  list of order for given client
     */
    public List<order> getClosedOrderForClient(int clientID ){
        List<order> before =this.clientService.getClientByID(clientID).getOclient_order();
        List<order> after = new ArrayList<>();
        for (order o: before) {
            if (o.isState()==false){
                after.add(o);
            }
        }
        return after;  }

    /**
     * return  order for given id
     * @param orderID the id of the client
     * @return  order
     */
    public order getOrderByID(int orderID ){
        return this.orderRepository.findById(orderID).orElse(null);
    }

    /**
     * update order data in  the database according to given id
     * @param  orderID the id of order
     * @param  newOrder the payload of the order to update in database
     */
    public void updateOrder(int orderID , order newOrder ){
        order oldOrder = this.orderRepository.findById(orderID).orElse(null);
        newOrder.setOrderID(orderID);
        modelMapper.map(newOrder,oldOrder);
        this.orderRepository.save(oldOrder);

    }
    /**
     * update State of order in  the database according to given id
     * @param  orderID the id of order
     * @param  state true of false
     */
    public void updateOrderForConfirm(int orderID , boolean state ){
        order oldOrder = this.orderRepository.findById(orderID).orElse(null);
        oldOrder.setState(state);
        this.orderRepository.save(oldOrder);

    }
    /**
     * update deliverState of order data in  the database according to given id
     * @param  orderID the id of order
     * @param  deliverState track the order
     */
    public void trackTheOrder(int orderID , String deliverState ){
        order oldOrder = this.orderRepository.findById(orderID).orElse(null);
        oldOrder.setDeliverState(deliverState);
        this.orderRepository.save(oldOrder);

    }
    /**
     * delete order data in  the database according to given id
     * @param  orderID the id of order
     */
    public void deleteOrder(int orderID ) {
        this.orderRepository.deleteById(orderID);
    }

}

