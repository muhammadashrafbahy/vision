package vision.army.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "productID", "image"})
public class productImage {
    public productImage() {super();    }

    public productImage(@JsonProperty("productID")int productID,
                        @JsonProperty("image")String image) {
        this.productID = productID;
        this.image = image;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prdImID;

    @Column( nullable = false)
    private int productID ;

    @Column( nullable = false)
    private String image ;

    public int getPrdImID() {
        return prdImID;
    }

    public void setPrdImID(int prdImID) {
        this.prdImID = prdImID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        productImage pd= (productImage) o;
        return Objects.equals(prdImID , pd.prdImID); }

    @Override
    public int hashCode() {

        return Objects.hash(prdImID);
    }
}
