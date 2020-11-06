package vision.army.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientID   ", "productID", "favDate"})
public class favourite {
    public favourite() {super();   }

    public favourite(@JsonProperty("clientID")int clientID,
                     @JsonProperty("productID")int productID,
                     @JsonProperty("favDate")Date favDate) {
        this.clientID = clientID;
        this.productID = productID;
        this.favDate = favDate;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favID;

    @Column( nullable = false)
    private int clientID;

    @Column( nullable = false)
    private int productID;

    @Column( nullable = false)
    private Date favDate;

    public int getFavID() {
        return favID;
    }

    public void setFavID(int favID) {
        this.favID = favID;
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

    public Date getFavDate() {
        return favDate;
    }

    public void setFavDate(Date favDate) {
        this.favDate = favDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        favourite f= (favourite) o;
        return Objects.equals(favID , f.favID); }

    @Override
    public int hashCode() {

        return Objects.hash(favID);
    }
}
