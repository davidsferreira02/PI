package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        int  credentialsValid = userService.checkCredentials(username, password);

        if (credentialsValid==1) {
            return "doctor";
        }
        else if (credentialsValid==2){
           return "pacient";
        }

        else {

            model.addAttribute("message", "Credenciais inválidas");
            return "login";
        }
    }
}
