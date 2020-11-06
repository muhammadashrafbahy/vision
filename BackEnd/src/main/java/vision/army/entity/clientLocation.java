package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientID   ", "lng", "lat"})

public class clientLocation {

    public clientLocation() {super();    }

    public clientLocation(@JsonProperty("clientID")int clientID,
                          @JsonProperty("lng")double lng,
                          @JsonProperty("lat")double lat) {
        this.clientID = clientID;
        this.lng = lng;
        this.lat = lat;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clLocationID ;

    @Column( nullable = false)
    private int clientID;

    @Column( nullable = false)
    private double lng;

    @Column( nullable = false)
    private double lat ;

    public int getClLocationID() {
        return clLocationID;
    }

    public void setClLocationID(int clLocationID) {
        this.clLocationID = clLocationID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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
