package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientID   ", "productID", "reSaleDate", "reason"})

public class resale {
    public resale() {super();    }

    public resale(@JsonProperty("clientID")int clientID,
                  @JsonProperty("productID")int productID,
                  @JsonProperty("reSaleDate")Date reSaleDate,
                  @JsonProperty("reason")String reason) {
        this.clientID = clientID;
        this.productID = productID;
        this.reSaleDate = reSaleDate;
        this.reason = reason;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reSaleID;

    @Column( nullable = false)
    private int clientID;

    @Column( nullable = false)
    private int productID;

    @Column( nullable = false)
    private Date reSaleDate;

    private String reason;

    public int getReSaleID() {
        return reSaleID;
    }

    public void setReSaleID(int reSaleID) {
        this.reSaleID = reSaleID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getReSaleDate() {
        return reSaleDate;
    }

    public void setReSaleDate(Date reSaleDate) {
        this.reSaleDate = reSaleDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        resale r= (resale) o;
        return Objects.equals(reSaleID , r.reSaleID); }

    @Override
    public int hashCode() {

        return Objects.hash(reSaleID);
    }
}
