package app;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    //@GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;


    public User(int pUserId, String pUsername, String pPassword, String pEmail) {
        this.id = pUserId;
        this.username = pUsername;
        this.password = pPassword;
        this.email = pEmail;
    }

    public User() {
        this.id = 0;
        this.username = "default";
        this.password = "default";
        this.email =  "default";
    }
    public User(int pId) {
        this.id = pId;
        this.username = "default";
        this.password = "default";
        this.email =  "default";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
}
