package app;
import java.util.Date;

public class Profile extends User{
    private String      firstName;
    private String      lastName;
    private int         age;
    private Date        birthDate;
    private String      picture;
    private String      city;
    private boolean     isMale; // 1 = male , 0 = female
    private String      description;

    public Profile(User user, String firstName, String lastName, int age, Date birthDate, String picture, String city, boolean isMale, String description) {
        super(user.getUsername(),user.getPassword(),user.getEmail());
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.picture = picture;
        this.city = city;
        this.isMale = isMale;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}