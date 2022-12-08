package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static app.Database.createDatabase;

@SpringBootApplication
public class DatingWebApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SpringApplication.run(DatingWebApp.class, args);
        app.Database.createDatabase();
    }

}
