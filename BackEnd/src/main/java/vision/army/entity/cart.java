package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "productID", "confirm",
        "cartDate", "confirmDate"})
public class cart {
    public cart() {super();    }


    public cart(@JsonProperty("productID")int productID,
                @JsonProperty("confirm")boolean confirm,
                @JsonProperty("cartDate")Date cartDate,
                @JsonProperty("confirmDate")Date confirmDate) {

        this.productID = productID;
        this.confirm = confirm;
        this.cartDate = cartDate;
        this.confirmDate = confirmDate;
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
