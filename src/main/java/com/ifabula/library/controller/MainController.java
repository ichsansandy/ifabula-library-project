package com.ifabula.library.controller;

import com.ifabula.library.model.User;
import com.ifabula.library.repository.UserRepository;
import com.ifabula.library.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    HomeService homeService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        homeService.prepareDataModelForIndexPage(principal.getName(), model);
        return "index";
    }
}
