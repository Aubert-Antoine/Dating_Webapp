package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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


}




