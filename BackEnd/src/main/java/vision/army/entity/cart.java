package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "productID", "confirm","cartDate", "confirmDate"
        ,"productPrice" ,"productQuantity" , "totalPrice"})
public class cart {
    public cart() {super();    }

// product quantity
    //product price
    public cart(@JsonProperty("productID")int productID,
                @JsonProperty("confirm")boolean confirm,
                @JsonProperty("cartDate")Date cartDate,
                @JsonProperty("confirmDate")Date confirmDate,
                @JsonProperty("productPrice") int productPrice,
                @JsonProperty("productQuantity")int productQuantity,
                @JsonProperty("totalPrice")int totalPrice) {

        this.productID = productID;
        this.confirm = confirm;
        this.cartDate = cartDate;
        this.confirmDate = confirmDate;
        this.productPrice =productPrice ;
        this.productQuantity= productQuantity;
        this.totalPrice = totalPrice;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;

    @Column( nullable = false)
    private int productID;

    @Column( nullable = false)
    private boolean confirm;

    @Column( nullable = false)
    private Date  cartDate ;

    private Date confirmDate ;

    @Column( nullable = false)
    private int productQuantity;

    @Column( nullable = false)
    private int productPrice;

    @Column( nullable = false)
    private int totalPrice;


    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Date getCartDate() {
        return cartDate;
    }

    public void setCartDate(Date cartDate) {
        this.cartDate = cartDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cart c= (cart) o;
        return Objects.equals(cartID , c.cartID); }

    @Override
    public int hashCode() {

        return Objects.hash(cartID);
    }


}
