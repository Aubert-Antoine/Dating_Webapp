package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/listAllUsers")
    public Iterable<User> getAll(){
        return repository.findAll();
    }
    @GetMapping("/signUpUser")
    public String addUser(@RequestParam  String username,@RequestParam String email, @RequestParam String password) {
        System.out.println("Get user" + username);
        User user = new User(username,email,password);
        for (User u: repository.findAll()){
            if(u.getEmail().equals(email)) {
                System.out.println("Error there is already a user with that email");
                return "there is already a user with that email";
            }
        }
        repository.save(user);
        System.out.println("Saved user" + username);
        return "registered";

    }

    @GetMapping("/loginUser")
    public RedirectView loginUser(@RequestParam  String username, @RequestParam String password) {
        for (User u : repository.findAll()) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    return new RedirectView("/login.html");
                }
            }
        }
        return new RedirectView("/login.html");
    }


}




