package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "prdType   ", "main"})

public class productType {
    public productType() {super(); }

    public productType(@JsonProperty("prdType")String prdType,
                       @JsonProperty("main")boolean main) {
        this.prdType = prdType;
        this.main = main;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prdTypeID;

    @Column( nullable = false)
    private String prdType;

    private boolean main ;

    public int getPrdTypeID() {
        return prdTypeID;
    }

    public void setPrdTypeID(int prdTypeID) {
        this.prdTypeID = prdTypeID;
    }

    public String getPrdType() {
        return prdType;
    }

    public void setPrdType(String prdType) {
        this.prdType = prdType;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        productType pr= (productType) o;
        return Objects.equals(prdTypeID , pr.prdTypeID); }

    @Override
    public int hashCode() {

        return Objects.hash(prdTypeID);
    }
}
