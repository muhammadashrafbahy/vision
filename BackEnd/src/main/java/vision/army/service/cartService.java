package vision.army.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import vision.army.reprositery.*;
import vision.army.entity.*;


@Service
public class cartService {
    private final  ModelMapper modelMapper = new ModelMapper();
    private cartRepository cartRepository;
    private clientService clientService ;
    @Autowired
    public cartService(cartRepository cartRepository ,clientService clientService) {
        this.cartRepository = cartRepository;
        this.clientService = clientService;
    }

    /**
     * create new cart for client in the database
     * @param newCart  the payload of the cart
     * @param clientID the id of the client
     */
    public void createAnCartForClient(int clientID , cart newCart){
        newCart.setCartDate(new Date());
        this.cartRepository.save(newCart);
        client client = this.clientService.getClientByID(clientID);
        List<cart> clCart = client.getAclient_cart();
        clCart.add(newCart);
        client.setAclient_cart(clCart);
        this.clientService.updateClient(clientID ,client);

    }
    /**
     * return list of cart for given client according to clientID
     * @param clientID the id of the client
     * @return  list of cart for given client
     */
    public List<cart> getCartForClient(int clientID ){
      return this.clientService.getClientByID(clientID).getAclient_cart();
    }

    /**
     * return  cart for given id
     * @param cartID the id of the client
     * @return  cart
     */
    public cart getCartByID(int cartID ){
        return this.cartRepository.findById(cartID).orElse(null);
    }

    /**
     * update cart data in  the database according to given id
     * @param  cartID the id of cart
     * @param  newCart the payload of the cart to update in database
     */
    public void updateCart(int cartID , cart newCart ){
        cart oldCart = this.cartRepository.findById(cartID).orElse(null);
        newCart.setCartID(cartID);
        modelMapper.map(newCart,oldCart);
        this.cartRepository.save(oldCart);

    }
    /**
     * update confirmed cart data in  the database according to given id
     * @param  cartID the id of cart
     * @param  confirm true of false
     */
    public void updateCartForConfirm(int cartID , boolean confirm ){
        cart oldCart = this.cartRepository.findById(cartID).orElse(null);
        oldCart.setConfirm(confirm);
        oldCart.setConfirmDate(new Date());
        this.cartRepository.save(oldCart);

    }
    /**
     * delete cart data in  the database according to given id
     * @param  cartID the id of cart
     */
    public void deleteCart(int cartID ) {
        this.cartRepository.deleteById(cartID);
    }

}
