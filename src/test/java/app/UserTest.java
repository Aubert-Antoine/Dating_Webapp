package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User(1, "username", "password", "email");
        assertEquals(1, user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("email", user.getEmail());
    }

    @Test
    public void testEmptyConstructor() {
        User user = new User();
        assertEquals(0, user.getId());
        assertEquals("default", user.getUsername());
        assertEquals("default", user.getPassword());
        assertEquals("default", user.getEmail());
    }

    @Test
    public void testIdConstructor() {
        User user = new User(1);
        assertEquals(1, user.getId());
        assertEquals("default", user.getUsername());
        assertEquals("default", user.getPassword());
        assertEquals("default", user.getEmail());
    }

    @Test
    public void testSetters() {
        User user = new User();
        user.setId(1);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        assertEquals(1, user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("email", user.getEmail());
    }


}
