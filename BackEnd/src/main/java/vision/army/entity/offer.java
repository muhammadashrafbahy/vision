package vision.army.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "productID", "description", "offerImage",
        "header", "fromD", "toD" ,"offerDate","saleNo"})
public class offer {
    public offer() {super();    }

    public offer(@JsonProperty("productID")int productID,
                 @JsonProperty("description")String description,
                 @JsonProperty("offerImage")String offerImage,
                 @JsonProperty("header")String header,
                 @JsonProperty("fromD")Date fromD,
                 @JsonProperty("toD")Date toD,
                 @JsonProperty("offerDate")Date offerDate,
                 @JsonProperty("saleNo")int saleNo) {
        this.productID = productID;
        this.description = description;
        this.offerImage = offerImage;
        this.header = header;
        this.fromD = fromD;
        this.toD = toD;
        this.offerDate = offerDate;
        this.saleNo = saleNo;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerID ;

    @Column( nullable = false)
    private int productID;

    @Column( nullable = false)
    private String description ;

    @Column( nullable = false)
    private String offerImage;

    @Column( nullable = false)
    private String header ;

    private Date fromD ;

    private Date toD ;

    @Column( nullable = false)
    private Date offerDate ;

    @Column( nullable = false)
    private int saleNo ;

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getFromD() {
        return fromD;
    }

    public void setFromD(Date fromD) {
        this.fromD = fromD;
    }

    public Date getToD() {
        return toD;
    }

    public void setToD(Date toD) {
        this.toD = toD;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public int getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(int saleNo) {
        this.saleNo = saleNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        offer of= (offer) o;
        return Objects.equals(offerID , of.offerID); }

    @Override
    public int hashCode() {

        return Objects.hash(offerID);
    }
}
