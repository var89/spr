package com.web.leaning;


import com.web.leaning.domain.User;
import com.web.leaning.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class RegistrationController {
    @Autowired
    UserRepo userRepo;
    RegistrationController(){}

    @PostMapping("/register")
    public String greeting(@RequestParam(name="username", required=true) String username,
                           @RequestParam(name="password", required=true) String password,
                           @RequestParam(name="email", required=true) String email, String name, Model model) {
        System.out.println("GET");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        User user = new User(username, password, email);
        userRepo.save(new User(username, password, email));
        return "success.json";
    }

    @PostMapping("/login/un")
    public String loginByUsername(@RequestParam(name="username", required=true) String username,
                           @RequestParam(name="password", required=true) String password, Model model) {
        System.out.println("GET");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        List<User> users;

        users = userRepo.findByUsernameAndPassword(username, password);
        User u = users.get(0);
        System.out.println(u.getUsername() + " " + u.getPassword() + " " + u.getEmail());
        return  "success.json";
    }


    @PostMapping("/login/em")
    public String loginByEmail(@RequestParam(name="email", required=true) String email,
                                  @RequestParam(name="password", required=true) String password, Model model) {
        System.out.println("GET");
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        List<User> users;

        users = userRepo.findByUsernameAndPassword(email, password);
        User u = users.get(0);
        System.out.println(u.getUsername() + " " + u.getPassword() + " " + u.getEmail());
        return  "success.json";
    }
}
