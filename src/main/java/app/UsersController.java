package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

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


        if(!Database.isEmailValid(email)) {
            System.out.println("Error there is already a user with that email");
            return "there is already a user with that email";
        }
        Database.fillUser(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
        System.out.println("Saved user " + username);
        return "registered";

    }

    @GetMapping("/loginUser")
    public RedirectView loginUser(@RequestParam  String username, @RequestParam String password) throws SQLException, ClassNotFoundException {

        if (Database.isUserValid(username, password)){
            System.out.println("Valid User");
        }
        else{
            System.out.println("Invalid User");
        }
        return new RedirectView("/login.html");
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
    public Profile[]  getallProfiles() {
        // write code to connect to db
        //get all profiles
        User user = new User(1, "maria", "test", "test");
        User user1 = new User(2, "test 1 ", "test 1 ", "test 1");
        Profile test = new Profile(user,"Maria","Je sais pas", 20,"test","/asset/favicon/favicon-16x16.png","Toulouse",true, "Je m'appel Maria");
        Profile test1 = new Profile(user1,"test 1 ","test 1", 10,"test","/asset/favicon/favicon-16x16.png","test",true, "test");
        Profile[] profiles = {test,test1};
        return profiles;

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




