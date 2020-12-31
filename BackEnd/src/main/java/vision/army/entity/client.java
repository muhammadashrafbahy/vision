package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientName   ", "clientEmail", "clientPassword",
        "clientImage", "gender", "birthDate" ,"phone"})
public class client {
    public client() {super();    }
    public client(client client) {super();    }

    public client(@JsonProperty("clientName")String clientName,
                  @JsonProperty("clientEmail")String clientEmail,
                  @JsonProperty("clientPassword")String clientPassword,
                  @JsonProperty("clientImage")String clientImage,
                  @JsonProperty("gender")String gender,
                  @JsonProperty("birthDate")Date birthDate,
                  @JsonProperty("phone")String phone) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPassword = clientPassword;
        this.clientImage = clientImage;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone=phone;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID ;

    @Column( nullable = false)
    private String clientName ;

    @Column( nullable = false)
    private String clientEmail;

    @Column( nullable = false)
    private String clientPassword;

    @Column( nullable = false)
    private String phone;

    private String clientImage;

    private String gender ;

    private Date birthDate ;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = clientLocation.class)
    @JoinTable(name = "Aclient_location" ,joinColumns = {@JoinColumn(name = "client_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "location_ID")} )
    @JsonIgnore
    private List<clientLocation> Aclient_location;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = cart.class)
    @JoinTable(name = "Cclient_cart" ,joinColumns = {@JoinColumn(name = "client_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "cart_ID")} )
    @JsonIgnore
    private List<cart> Aclient_cart;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = resale.class)
    @JoinTable(name = "Rclient_resale" ,joinColumns = {@JoinColumn(name = "client_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "resale_ID")} )
    @JsonIgnore
    private List<resale> Rclient_resale;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = favourite.class)
    @JoinTable(name = "Fclient_favourite" ,joinColumns = {@JoinColumn(name = "client_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "favourite_ID")} )
    @JsonIgnore
    private List<favourite> Fclient_favourite;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = orders.class)
    @JoinTable(name = "ORclientorders" ,joinColumns = {@JoinColumn(name = "client_ID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "orders_ID")} )
    @JsonIgnore
    private List<orders> Orclient_orders;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientImage() {
        return clientImage;
    }

    public void setClientImage(String clientImage) {
        this.clientImage = clientImage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonIgnore
    public List<clientLocation> getAclient_location() {
        return Aclient_location;
    }

    public void setAclient_location(List<clientLocation> aclient_location) {
        Aclient_location = aclient_location;
    }

    @JsonIgnore
    public List<cart> getAclient_cart() {
        return Aclient_cart;
    }

    public void setAclient_cart(List<cart> aclient_cart) {
        Aclient_cart = aclient_cart;
    }

    @JsonIgnore
    public List<resale> getRclient_resale() {
        return Rclient_resale;
    }

    public void setRclient_resale(List<resale> rclient_resale) {
        Rclient_resale = rclient_resale;
    }

    @JsonIgnore
    public List<favourite> getFclient_favourite() {
        return Fclient_favourite;
    }

    public void setFclient_favourite(List<favourite> fclient_favourite) {
        Fclient_favourite = fclient_favourite;
    }

    @JsonIgnore
    public List<orders> getOrclient_orders() {
        return Orclient_orders;
    }

    public void setOrclient_orders(List<orders> orclient_orders) {
        Orclient_orders = orclient_orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        client c= (client) o;
        return Objects.equals(clientID , c.clientID); }

    @Override
    public int hashCode() {

        return Objects.hash(clientID);
    }
}
