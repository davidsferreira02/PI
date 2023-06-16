package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class SpringController {
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String loadCars(@ModelAttribute("model") ModelMap model) {
        String[] carlist = {"Ferrari", "Mercedes", "Audi"};
        model.addAttribute("carList", carlist);
        return "index";
    }
}
