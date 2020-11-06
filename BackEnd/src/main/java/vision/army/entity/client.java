package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "clientName   ", "clientEmail", "clientPassword",
        "clientImage", "gender", "birthDate"})
public class client {
    public client() {super();    }
    public client(client client) {super();    }

    public client(@JsonProperty("clientName")String clientName,
                  @JsonProperty("clientEmail")String clientEmail,
                  @JsonProperty("clientPassword")String clientPassword,
                  @JsonProperty("clientImage")String clientImage,
                  @JsonProperty("gender")String gender,
                  @JsonProperty("birthDate")Date birthDate) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPassword = clientPassword;
        this.clientImage = clientImage;
        this.gender = gender;
        this.birthDate = birthDate;
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

    private String clientImage;

    private String gender ;

    private Date birthDate ;

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
