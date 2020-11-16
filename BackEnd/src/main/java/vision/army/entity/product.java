package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "prodName", "prodPrice", "description",
        "prdTypeID", "brandID", "state",
        "rate", "salesNo", "itemNo","prdTypeMainID"})
public class product {
    public product() {super();    }


    public product(@JsonProperty("prodName")String prodName,
                   @JsonProperty("prodPrice")int prodPrice,
                   @JsonProperty("description")String description,
                   @JsonProperty("prdTypeID")int prdTypeID,
                   @JsonProperty("brandID")int brandID,
                   @JsonProperty("state")String state,
                   @JsonProperty("rate")int rate,
                   @JsonProperty("salesNo")int salesNo,
                   @JsonProperty("itemNo")int itemNo,
                   @JsonProperty("prdTypeMainID")int prdTypeMainID) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.description = description;
        this.prdTypeID = prdTypeID;
        this.brandID = brandID;
        this.state = state;
        Rate = rate;
        this.salesNo = salesNo;
        this.itemNo = itemNo;
        this.prdTypeMainID = prdTypeMainID;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column( nullable = false)
    private String prodName ;

    @Column( nullable = false)
    private int prodPrice ;

    @Column( nullable = false)
    private String description ;

    @Column( nullable = false)
    private int prdTypeID ;

    @Column( nullable = false)
    private int brandID;

    @Column( nullable = false)
    private String state ;

    private int Rate ;

    private int salesNo ;

    @Column( nullable = false)
    private int itemNo ;

    @Column( nullable = false)
    private int prdTypeMainID;


        @OneToMany(cascade = CascadeType.ALL, targetEntity = productImage.class)
    @JoinTable(name = "Aproduct_images" ,joinColumns = {@JoinColumn(name = "product_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "image_ID")} )
    private List<productImage> AproductImages;


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrdTypeID() {
        return prdTypeID;
    }

    public void setPrdTypeID(int prdTypeID) {
        this.prdTypeID = prdTypeID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public int getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getPrdTypeMainID() {
        return prdTypeMainID;
    }

    public void setPrdTypeMainID(int prdTypeMainID) {
        this.prdTypeMainID = prdTypeMainID;
    }

    public List<productImage> getProductImages() {
        return AproductImages;
    }

    public void setProductImages(List<productImage> productImages) {
        this.AproductImages = productImages;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        product p= (product) o;
        return Objects.equals(prdTypeID , p.prdTypeID); }

    @Override
    public int hashCode() {

        return Objects.hash(prdTypeID);
    }
}
