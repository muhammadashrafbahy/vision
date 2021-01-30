package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.web.bind.annotation.ModelAttribute;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class ordersService {
    private final ModelMapper modelMapper = new ModelMapper();
    private productService  productService;
    private ordersRepository ordersRepository;
    private clientService clientService;
    private clientLocationService clientLocationService;


    @Autowired
    public ordersService(@Lazy productService  productService, ordersRepository ordersRepository, clientService clientService
            , clientLocationService clientLocationService) {
        this.ordersRepository = ordersRepository;
        this.clientService = clientService;
        this.clientLocationService = clientLocationService;
        this.productService =  productService;
    }

    /**
     * create new orders for client in the database
     *
     * @param newOrders the payload of the orders
     * @param clientID  the id of the client
     */
    public void createAnOrdersForClient(int clientID, orders newOrders) {
        product product = this.productService.getProductByID(newOrders.getProductID());
         int  totalPrice = product.getProdPrice()* newOrders.getProductQuantity();
         newOrders.setTotalPrice(totalPrice);
         newOrders.setProductPrice(product.getProdPrice());
        this.ordersRepository.save(newOrders);
        client client = this.clientService.getClientByID(clientID);
        List<orders> clOrders = client.getOrclient_orders();
        clOrders.add(newOrders);
        client.setOrclient_orders(clOrders);
        this.clientService.updateClient(clientID, client);

        List<orders> ordersList = product.getORproductOrders();
        ordersList.add(newOrders);
        product.setORproductOrders(ordersList);
        this.productService.updateAnProduct(product ,newOrders.getProductID());

    }

    /**
     * check If Product In orders State
     *
     * @param productID the id of the product
     * @return exist or not
     */
    public boolean checkIfProductInorders(int productID) {
        orders orders = this.ordersRepository.findByProductID(productID);
        if (orders == null) {
            return false;
        } else {

            return true;
        }
    }

    /**
     * return list of all orders
     *
     * @return list of orders
     */
    public List<customizedOrder> getAllOrders() {
        List<orders> ordersList = this.ordersRepository.findAll();
        List<Integer> clientOfOrders = new ArrayList<>();
        for (orders orders : ordersList) {
            clientOfOrders.add(orders.getClient().getClientID());
        }
        Set<Integer> set = new HashSet<Integer>(clientOfOrders);
        clientOfOrders.clear();
        clientOfOrders.addAll(set);
        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (int i : clientOfOrders) {
            customizedOrderList.add(this.getAllOrdersForClient(i));
        }


        return customizedOrderList;

    }

    /**
     * return list of orders for given client according to clientID
     *
     * @param clientID the id of the client
     * @return list of orders for given client
     */
    public List<orders> getOrdersForClient(int clientID) {
        return this.clientService.getClientByID(clientID).getOrclient_orders();
    }

    /**
     * return list of orders for given client according to clientID
     *
     * @param clientID the id of the client
     * @return list of orders for given client
     */
    public customizedOrder getAllOrdersForClient(int clientID) {
        List<orders> ordersList = this.getOrdersForClient(clientID);
        client client = this.clientService.getClientByID(clientID);
        customizedOrder customizedOrder = new customizedOrder();

        clientLocation clientLocation = this.clientLocationService.getClientLocationForClient(clientID).get(0);
        String city = clientLocation.getCity();
        String country = clientLocation.getCountry();
        String address = clientLocation.getAddress();

        int prodNo = 0;
        int totalPrice = 0;

        for (orders order : ordersList) {
            prodNo = prodNo + order.getProductQuantity();
            totalPrice = totalPrice + order.getTotalPrice();
        }

        customizedOrder.setClientLocation(country + " " + city + " " + address);
        customizedOrder.setClientName(client.getClientName());
        customizedOrder.setClientPhone(client.getPhone());
        customizedOrder.setOrderNo(ordersList.size());
        customizedOrder.setProductNo(prodNo);
        customizedOrder.setTotalOrderPrice(totalPrice);
        customizedOrder.setClientID(clientID);

        return customizedOrder;
    }

    /**
     * return list of  orders by state for given client according to clientID
     *
     * @param clientID the id of the client
     * @param State    the State of the order
     * @return list of orders for given client
     */
    public List<orders> getOrdersByStateForClient(int clientID, boolean State) {
        List<orders> before = this.clientService.getClientByID(clientID).getOrclient_orders();
        List<orders> after = new ArrayList<>();
        for (orders o : before) {
            if (o.isState()) {
                after.add(o);
            }
        }
        return after;
    }

    /**
     * return list of  orders by state
     *
     * @param state the State of the order
     * @return list of orders
     */
    public List<customizedOrder> getOrdersByState(boolean state) {
        List<orders> ordersList = this.ordersRepository.findAllByState(state);
        List<Integer> clientOfOrders = new ArrayList<>();
        for (orders orders : ordersList) {
            System.out.println("------------------->"+orders.getClient().getClientName());
            clientOfOrders.add(orders.getClient().getClientID());
        }
        Set<Integer> set = new HashSet<Integer>(clientOfOrders);
        clientOfOrders.clear();
        clientOfOrders.addAll(set);
        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (int i : clientOfOrders) {
            customizedOrderList.add(this.getAllOrdersForClient(i));
        }


        return customizedOrderList;
    }

    /**
     * return list of  orders by deliveredDate
     *
     * @param deliveredDate the date of the deliver
     * @return list of orders
     */
    public List<customizedOrder> getOrdersByDeliveredDate(Date deliveredDate) {
        List<orders> ordersList = this.ordersRepository.findAllByDeliveredDate(deliveredDate);
        List<Integer> clientOfOrders = new ArrayList<>();
        for (orders orders : ordersList) {
            clientOfOrders.add(orders.getClient().getClientID());
        }
        Set<Integer> set = new HashSet<Integer>(clientOfOrders);
        clientOfOrders.clear();
        clientOfOrders.addAll(set);
        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (int i : clientOfOrders) {
            customizedOrderList.add(this.getAllOrdersForClient(i));
        }


        return customizedOrderList;
    }


    /**
     * return list of  orders by orderDate
     * @param date the date of the order
     * @return  list of orders
     */
    public List<customizedOrder> getOrdersByOrderDate(Date date )
    {
        List<orders> ordersList = this.ordersRepository.findAllByOrderDate(date);
        List  <Integer>  clientOfOrders = new ArrayList<>();
        for (orders orders:ordersList ) {
            clientOfOrders.add(orders.getClient().getClientID());
        }
        Set<Integer> set = new HashSet<Integer>(clientOfOrders);
        clientOfOrders.clear();
        clientOfOrders.addAll(set);
        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (int i :clientOfOrders  ) {
            customizedOrderList.add(this.getAllOrdersForClient(i));
        }


        return  customizedOrderList ;
    }

    /**
     * return list of  orders by price range
     * @param price1
     * @param price2
     * @return  list of orders
     */
    public List<customizedOrder> getOrdersByPriceRang(int price1 , int price2 ){
        List<orders>  ordersList =this.ordersRepository.findAllByDeliverPriceBetween(price1,price2);
        List  <Integer>  clientOfOrders = new ArrayList<>();
        for (orders orders:ordersList ) {
            clientOfOrders.add(orders.getClient().getClientID());
        }
        Set<Integer> set = new HashSet<Integer>(clientOfOrders);
        clientOfOrders.clear();
        clientOfOrders.addAll(set);
        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (int i :clientOfOrders  ) {
            customizedOrderList.add(this.getAllOrdersForClient(i));
        }


        return  customizedOrderList ;

    }
    /**
     * return list of  orders by client name
     *
     * @param name of the client
     * @return list of orders
     */
    public List<customizedOrder> getOrdersByClientName(String name) {
        List<client> clientOfOrders = this.clientService.getClientByName(name);

        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (client client : clientOfOrders) {
            customizedOrderList.add(this.getAllOrdersForClient(client.getClientID()));
        }


        return customizedOrderList;
    }

    /**
     * return list of  orders by client phone
     *
     * @param phone of the client
     * @return list of orders
     */
    public List<customizedOrder> getOrdersByClientPhone(String phone) {
        List<client> clientOfOrders  = this.clientService.getClientByPhone(phone);

        List<customizedOrder> customizedOrderList = new ArrayList<>();
        for (client client : clientOfOrders) {
            customizedOrderList.add(this.getAllOrdersForClient(client.getClientID()));
        }


        return customizedOrderList;
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
    public void updateOrdersState(int ordersID , boolean state , Date deliverDate  , int DeliverPrice , int totalPrice ){
        orders oldOrders = this.ordersRepository.findById(ordersID).orElse(null);
        oldOrders.setState(state);
        oldOrders.setTotalPrice(totalPrice);
        oldOrders.setDeliveredDate(deliverDate);
        oldOrders.setDeliverPrice(DeliverPrice);
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

