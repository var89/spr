package com.web.leaning;


import com.web.leaning.domain.User;
import com.web.leaning.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    public GreetingController() {
    }

    @GetMapping
    public String main2(Map<String, Object> model){
        return "greeting";
    }


}
