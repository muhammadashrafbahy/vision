package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;


@Entity
@JsonPropertyOrder({ "state", "deliverPeriod","deliverPrice", "deliverState"  , "productID"})
public class order {

    public order() {    super();    }

    public order(@JsonProperty("state") boolean state,
                 @JsonProperty("productID") String productID,
                 @JsonProperty("deliverPeriod")String deliverPeriod,
                 @JsonProperty("deliverPrice")int deliverPrice,
                 @JsonProperty("deliverState")String deliverState) {
        this.state = state;
        this.deliverPeriod = deliverPeriod;
        this.deliverPrice = deliverPrice;
        this.deliverState = deliverState;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID ;

    @Column( nullable = false)
    private boolean state ;

    @Column( nullable = false)
    private int productID ;

    private String deliverPeriod;

    private int deliverPrice ;

    @Column( nullable = false)
    private String  deliverState;


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDeliverPeriod() {
        return deliverPeriod;
    }

    public void setDeliverPeriod(String deliverPeriod) {
        this.deliverPeriod = deliverPeriod;
    }

    public int getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(int deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public String getDeliverState() {
        return deliverState;
    }

    public void setDeliverState(String deliverState) {
        this.deliverState = deliverState;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        order or= (order) o;
        return Objects.equals(or.orderID , or.orderID); }

    @Override
    public int hashCode() {

        return Objects.hash(orderID);
    }

}
