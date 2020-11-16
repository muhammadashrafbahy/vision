package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({  "productID", "reSaleDate", "reason","confirm"})

public class resale {
    public resale() {super();    }

    public resale(@JsonProperty("productID")int productID,
                  @JsonProperty("reSaleDate")Date reSaleDate,
                  @JsonProperty("confirmDate")Date confirmDate,
                  @JsonProperty("reason")String reason,
                  @JsonProperty("confirm")boolean confirm) {

        this.productID = productID;
        this.reSaleDate = reSaleDate;
        this.reason = reason;
        this.confirm=confirm;
        this.confirmDate =confirmDate;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reSaleID;

    @Column( nullable = false)
    private int productID;

    @Column( nullable = false)
    private Date reSaleDate;

    @Column( nullable = false)
    private Date confirmDate;

    @Column( nullable = false)
    private boolean confirm;

    private String reason;

    public int getReSaleID() {
        return reSaleID;
    }

    public void setReSaleID(int reSaleID) {
        this.reSaleID = reSaleID;
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

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
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
