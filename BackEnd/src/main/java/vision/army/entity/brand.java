package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "brandName", "logo", "description"})
public class brand {
    public brand() {super();    }


    public brand(@JsonProperty("brandName")String brandName,
                 @JsonProperty("logo")String logo,
                 @JsonProperty("description")String description) {
        this.brandName = brandName;
        this.logo = logo;
        this.description = description;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID ;

    @Column( nullable = false)
    private String brandName;

    private String logo ;

    private String description;

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        brand b= (brand) o;
        return Objects.equals(brandID , b.brandID); }

    @Override
    public int hashCode() {

        return Objects.hash(brandID);
    }
}
