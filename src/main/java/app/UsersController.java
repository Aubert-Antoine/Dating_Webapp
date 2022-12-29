package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/listAllUsers")
    public Iterable<User> getAll(){
        return repository.findAll();
    }
    @GetMapping("/signUpUser")
    public String addUser(@RequestParam  String username,@RequestParam String email, @RequestParam String password) throws SQLException, ClassNotFoundException {
        System.out.println("Get user" + username);
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        Profile profile = new Profile();


        if(!Database.isEmailValid(email)){
            System.out.println("Error there is already a user with that email");
            return "there is already a user with that email";
        }
        Database.newUser(user,profile);

        System.out.println("Saved user " + username);
        return "registered";

    }

    @GetMapping("/loginUser")
    public RedirectView loginUser(@RequestParam  String username, @RequestParam String password) throws SQLException, ClassNotFoundException {

        if (Database.isUserValid(username, password)){
            System.out.println("Valid User");
            return new RedirectView("/main.html");
        }
        else{
            System.out.println("Invalid User");
            return new RedirectView("/login.html");
        }
    }

    @GetMapping("")
    public RedirectView redirect(){
        return new RedirectView("login.html");
    }



    @GetMapping("/likes")
    public void registerLike(@RequestParam int from,@RequestParam int to ) throws SQLException, ClassNotFoundException {
        //register that user with id "from" likes user with id "to".
        Database.acceptProfile(from,to);
        System.out.println("User with id "+ from + " likes user with id "+ to);
    }
    @GetMapping("/dislikes")
    public void registerDisLike(@RequestParam int from,@RequestParam int to ) throws SQLException, ClassNotFoundException {
        //register that user with id "from" dislikes user with id "to".
        Database.refuseProfile(from,to);
        System.out.println("User with id "+ from + " dislikes user with id "+ to);
    }
    @GetMapping("/profiles")
    public ArrayList<Profile>  getallProfiles(@RequestParam int id) throws SQLException, ClassNotFoundException {
        // write code to connect to db
        //get all profiles
        User user = new User(1, "maria", "test", "test");
        User user1 = new User(2, "test 1 ", "test 1 ", "test 1");
        Profile test = new Profile(user,"Antoine","Aubert", 20,"test","/asset/favicon/favicon-16x16.png","Toulouse",true, "Je m'appel Maria");
        Profile test1 = new Profile(user1,"Benoit","Marchadier", 20,"test","/asset/favicon/favicon-16x16.png","Paris",true, "Bonjour ! Je suis un étudiant ingénieur de 20 ans basé à Paris. J'adore le sport et j'aime rester en forme en pratiquant régulièrement de la musculation et en allant courir ou jouer au foot. Je suis également passionné de technologie et j'aime tout ce qui touche à l'innovation et à la découverte de nouvelles choses. Je suis quelqu'un de sociable et j'aime passer du temps avec mes amis et ma famille. J'apprécie les sorties en ville, les concerts et les soirées entre amis. Je suis également quelqu'un de sérieux et j'aime travailler dur pour atteindre mes objectifs. Si tu cherches quelqu'un de dynamique, passionné et ambitieux, n'hésite pas à me contacter !");
        ArrayList<Profile>  list = new ArrayList<>();
        list.add(test);
        list.add(test1);
//
//        Stack<Profile> stack = Database.getProfiles(id,5);
//        ArrayList<Profile> list = new ArrayList<>();
//        while(!stack.isEmpty()) {
//            list.add(stack.pop());
//        }
        return list;

    }

    @GetMapping("/profile")
    public Iterable<Profile>  getaProfile() {
        // write code to connect to db
        //get a profile not yet shown to the user
        User user = new User(1, "maria", "test", "test");
        Profile test1 = new Profile(user,"test 1 ","test 1", 0,"test","/asset/favicon/favicon-16x16.png","test",true, "test");
        ArrayList<Profile>  list = new ArrayList<>();
        list.add(test1);
        return list;

    }

    @GetMapping("/anotherprofile")
    public Iterable<Profile>  getanotherProfile() {
        // write code to connect to db
        //get a profile not yet shown to the user
        User user = new User(2, "George", "George", "test");
        Profile test1 = new Profile(user,"Geroge ","George 1", 0,"test","/asset/favicon/favicon-16x16.png","test",true, "test");
        ArrayList<Profile>  list = new ArrayList<>();
        list.add(test1);
        return list;

    }



}




