package com.ifabula.library.controller;

import com.ifabula.library.repository.UserRepository;
import com.ifabula.library.services.HomeService;
import com.ifabula.library.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class RentController {

    @Autowired
    RentService rentService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HomeService homeService;

    @PostMapping("/rent/{bookId}")
    public String createRent(@PathVariable int bookId, Principal principal, Model model, RedirectAttributes redirectAttributes){
        try {
            rentService.rentBook(bookId,principal.getName());
            homeService.prepareDataModelForIndexPage(principal.getName(),model);
            redirectAttributes.addAttribute("successMessage", "Book rented");
            return "redirect:/?success";
        } catch (Error e){
            redirectAttributes.addAttribute("errorMessage", e.getMessage());
            return "redirect:/?error";
        }
    }

    @PostMapping("/return/{bookId}")
    public String returnBook(@PathVariable int bookId, Principal principal, Model model, RedirectAttributes redirectAttributes){
        try {
            rentService.returnBook(bookId,principal.getName());
            homeService.prepareDataModelForIndexPage(principal.getName(),model);
            redirectAttributes.addAttribute("successMessage", "Book return");
            return "redirect:/?success";
        } catch (Error e){
            redirectAttributes.addAttribute("errorMessage", e.getMessage());
            return "redirect:/?error";
        }
    }
}
