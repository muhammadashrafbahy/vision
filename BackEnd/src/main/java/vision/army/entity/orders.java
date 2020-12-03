package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@JsonPropertyOrder({ "state", "deliverPeriod","deliverPrice" ,"deliveredDate" , "productID"
        ,"productPrice" ,"productQuantity" , "totalPrice"})
public class orders {

    public orders() {    super();    }
// productQuantity
    public orders(@JsonProperty("deliveredDate") Date deliveredDate,
                  @JsonProperty("state") String state,
                 @JsonProperty("productID") int productID,
                 @JsonProperty("deliverPeriod")String deliverPeriod,
                 @JsonProperty("deliverPrice")int deliverPrice,
                  @JsonProperty("productPrice") int productPrice,
                  @JsonProperty("productQuantity")int productQuantity,
                  @JsonProperty("totalPrice")int totalPrice
                 ) {
        this.productID =productID;
        this.deliveredDate = deliveredDate;
        this.state = state;
        this.deliverPeriod = deliverPeriod;
        this.deliverPrice = deliverPrice;
        this.productPrice =productPrice ;
        this.productQuantity= productQuantity;
        this.totalPrice = totalPrice;


    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordersID ;

    @Column( nullable = false)
    private String state ;

    @Column( nullable = false)
    private int productID ;

    private String deliverPeriod;

    private int deliverPrice ;

    @Column( nullable = false)
    private Date orderDate ;

    @Column( nullable = false)
    private int productQuantity;

    @Column( nullable = false)
    private int productPrice;

    @Column( nullable = false)
    private int totalPrice;

    private Date deliveredDate ;

    public int getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(int ordersID) {
        this.ordersID = ordersID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
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
        orders or= (orders) o;
        return Objects.equals(or.ordersID , or.ordersID); }

    @Override
    public int hashCode() {

        return Objects.hash(ordersID);
    }

}
