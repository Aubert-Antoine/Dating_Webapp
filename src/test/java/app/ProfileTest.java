package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    @Test
    public void testConstructor() {
        User user = new User(1, "username", "password", "email@example.com");
        Profile profile = new Profile(user, "firstName", "lastName", 25, "01/01/1996", "picture.jpg", "city", true, "description");

        assertEquals(1, profile.getId());
        assertEquals("username", profile.getUsername());
        assertEquals("password", profile.getPassword());
        assertEquals("email@example.com", profile.getEmail());
        assertEquals("firstName", profile.getFirstName());
        assertEquals("lastName", profile.getLastName());
        assertEquals(25, profile.getAge());
        assertEquals("01/01/1996", profile.getBirthDate());
        assertEquals("picture.jpg", profile.getPicture());
        assertEquals("city", profile.getCity());
        assertEquals(true, profile.isMale());
        assertEquals("description", profile.getDescription());
    }

    @Test
    public void testSetters() {
        Profile profile = new Profile();
        profile.setId(1);
        profile.setUsername("username");
        profile.setPassword("password");
        profile.setEmail("email@example.com");
        profile.setFirstName("firstName");
        profile.setLastName("lastName");
        profile.setAge(25);
        profile.setBirthDate("01/01/1996");
        profile.setPicture("picture.jpg");
        profile.setCity("city");
        profile.setMale(false);
        profile.setDescription("description");

        assertEquals(1, profile.getId());
        assertEquals("username", profile.getUsername());
        assertEquals("password", profile.getPassword());
        assertEquals("email@example.com", profile.getEmail());
        assertEquals("firstName", profile.getFirstName());
        assertEquals("lastName", profile.getLastName());
        assertEquals(25, profile.getAge());
        assertEquals("01/01/1996", profile.getBirthDate());
        assertEquals("picture.jpg", profile.getPicture());
        assertEquals("city", profile.getCity());
        assertEquals(false, profile.isMale());
        assertEquals("description", profile.getDescription());
    }
}
