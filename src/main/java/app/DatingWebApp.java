package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.Date;
import java.util.Stack;

@SpringBootApplication
public class DatingWebApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SpringApplication.run(DatingWebApp.class, args);
//        Database.createDatabase();
//        Database.fillUser(1,"bebe0106","benoit.marchadier@edu.esiee.fr","benoitpassword");
//        Database.fillUser(2,"AntoineAub","antoine.aubert@edu.esiee.fr","antoinepassword");
//        Database.fillUser(3,"juju312000","marchadier.julien@gmail.com","julienpassword");
//        Database.fillUser(4,"PauF","pauline.fontaine@edu.esiee.fr","paulinepassword");
//        Database.fillUser(5,"PauG","pauline.gouillart@edu.esiee.fr","paulinepassword");
//        Database.fillUser(6,"Coralie","coralie.foulart@edu.esiee.fr","coraliepassword");
//        Database.fillProfile(1,"Benoit","Marchadier",20,"06/01","benoit.jpg","Toulouse",true,"I ame Benoit");
//        Database.fillProfile(2,"Antoine","Aubert",20,"26/07","antoine.jpg","Nice",true,"I ame Antoine");
//        Database.fillProfile(3,"Julien","Marchadier",22,"20/01","julien.jpg","Toulouse",true,"I ame Julien");
//        Database.fillProfile(4,"Pauline","Fontaine",20,"26/07","paulineF.jpg","Paris",false,"I ame PaulineF");
//        Database.fillProfile(5,"Pauline","Gouillart",20,"13/01","paulineG.jpg","Paris",false,"I ame PaulineG");
//        Database.fillProfile(6,"Coralie","Foulart",20,"05/05","Coralie.jpg","Paris",false,"I ame Coralie");
//
//        User UserBenoit = new User("bebe0106","benoit.marchadier@edu.esiee.fr","benoitpassword");
//        Profile ProfileBenoit = new Profile(UserBenoit,"Benoit","Marchadier",20,"06/01/2002","benoit.jpg","Toulouse",true,"I ame Benoit");
//        ProfileBenoit.setId(1);
//        Profile ProfilePauline = new Profile("Pauline","Gouillart",20,"06/01/2002","benoit.jpg","Toulouse",false,"I ame Benoit");
//        ProfilePauline.setId(4);
//        Profile ProfileCoralie = new Profile("Coralie","Foulart",20,"06/01/2002","benoit.jpg","Toulouse",false,"I ame Benoit");
//        ProfileCoralie.setId(6);
//
//        Stack profiles = Database.getProfiles(ProfileBenoit,5);
//        System.out.println("taille du tableau : "+profiles.size());
//        for (int i=0;i<profiles.size();i++){
//            System.out.println(profiles.get(i));
//        }
//        Stack profiles = Database.getProfiles(ProfilePauline,2);
//        System.out.println("taille du tableau : "+profiles.size());
//        for (int i=0;i<profiles.size();i++){
//            System.out.println(profiles.get(i));
//        }
//        Database.acceptProfile(ProfileBenoit,ProfileCoralie);
//        Database.acceptProfile(ProfileCoralie,ProfileBenoit);
//        Database.refuseProfile(ProfilePauline,ProfileBenoit);

    }

}
