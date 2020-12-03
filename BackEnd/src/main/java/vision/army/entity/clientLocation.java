package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientLocationName","lng", "lat","city" ,"country","address"})

public class clientLocation {

    public clientLocation() {super();    }


    // city
    // country
    //address
    public clientLocation(@JsonProperty("clientLocationName")String clientLocationName,
                          @JsonProperty("lng")double lng,
                          @JsonProperty("lat")double lat,
                          @JsonProperty("city")String city,
                          @JsonProperty("country")String country,
                          @JsonProperty("address")String address) {
        this.clientLocationName = clientLocationName ;
        this.lng = lng;
        this.lat = lat;
        this.city = city ;
        this.country = country;
        this.address = address;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clLocationID ;

    private double lng;

    private double lat ;

    private String city ;

    private String address ;

    private String country ;

    private String clientLocationName;

    public int getClLocationID() {
        return clLocationID;
    }

    public void setClLocationID(int clLocationID) {
        this.clLocationID = clLocationID;
    }



    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getClientLocationName() {
        return clientLocationName;
    }

    public void setClientLocationName(String clientLocationName) {
        this.clientLocationName = clientLocationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        clientLocation u= (clientLocation) o;
        return Objects.equals(clLocationID, u.clLocationID); }

    @Override
    public int hashCode() {

        return Objects.hash(clLocationID);
    }
}
