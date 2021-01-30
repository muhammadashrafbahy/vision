package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
@JsonPropertyOrder({ "clientName", "clientPhone", "clientLocation",
        "productNo", "orderNo", "totalOrderPrice" })
public class customizedOrder {

    private int clientID ;
    private String clientName ;
    private String clientPhone  ;
    private String clientLocation ;
    private int ProductNo ;
    private int orderNo ;
    private int totalOrderPrice ;

    public customizedOrder() {
    }

    public customizedOrder(@JsonProperty("clientName")String clientName,
                           @JsonProperty("clientPhone")String clientPhone,
                           @JsonProperty("clientLocation")String clientLocation,
                           @JsonProperty("productNo")int productNo,
                           @JsonProperty("orderNo")int orderNo,
                           @JsonProperty("totalOrderPrice")int totalOrderPrice) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientLocation = clientLocation;
        ProductNo = productNo;
        this.orderNo = orderNo;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public int getProductNo() {
        return ProductNo;
    }

    public void setProductNo(int productNo) {
        ProductNo = productNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
