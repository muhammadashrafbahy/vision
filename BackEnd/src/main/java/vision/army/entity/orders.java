package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;


@Entity
@JsonPropertyOrder({ "state", "deliverPeriod","deliverPrice", "deliverState"  , "productID"})
public class orders {

    public orders() {    super();    }

    public orders(@JsonProperty("state") boolean state,
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
    private int ordersID ;

    @Column( nullable = false)
    private boolean state ;

    @Column( nullable = false)
    private int productID ;

    private String deliverPeriod;

    private int deliverPrice ;

    @Column( nullable = false)
    private String  deliverState;

    public int getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(int ordersID) {
        this.ordersID = ordersID;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        orders or= (orders) o;
        return Objects.equals(or.ordersID , or.ordersID); }

    @Override
    public int hashCode() {

        return Objects.hash(ordersID);
    }

}
