package vision.army.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "fullName   ", "userName", "password",
        "images", "privilegeN", "userEmail"})

public class user {
    public user() { super();    }
    public user(user user) { super();    }
//    @JsonProperty("")
    public user(@JsonProperty("fullName")String fullName,
                @JsonProperty("userName")String userName,
                @JsonProperty("password") String password,
                @JsonProperty("images")String image,
                @JsonProperty("privilegeN")int privilegeN,
                @JsonProperty("userEmail")String userEmail) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.image = image;
        this.privilegeN = privilegeN;
        this.userEmail =userEmail;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID ;


    private String fullName ;

    @Column( nullable = false)
    private String userName ;

    @Column( nullable = false)
    private String password ;

    private String image ;

    private String userEmail;


    private int privilegeN;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getPrivilegeN() {
        return privilegeN;
    }

    public void setPrivilegeN(int privilegeN) {
        this.privilegeN = privilegeN;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user u= (user) o;
        return Objects.equals(userID , u.userID); }

    @Override
    public int hashCode() {

        return Objects.hash(userID);
    }
}
