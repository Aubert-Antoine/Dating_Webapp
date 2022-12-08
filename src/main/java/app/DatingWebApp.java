package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DatingWebApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SpringApplication.run(DatingWebApp.class, args);
//        Database.createDatabase();
//        Database.fillUser(1,"bebe0106","benoit.marchadier@edu.esiee.fr","bebepassword");
//        Database.fillProfile(1,"Benoit","Marchadier",20,"06/01","bebe.jpg","Toulouse",true,"I ame Benoit");
    }

}
