package com.ifabula.library.controller;

import java.util.List;

import com.ifabula.library.dto.UserRegistrationDto;
import com.ifabula.library.services.RoleService;
import com.ifabula.library.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifabula.library.model.Role;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;
    private RoleService roleService;
    public UserRegistrationController(UserService userService, RoleService roleService) {
        super();
        this.userService = userService;
        this.roleService = roleService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {

        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto,Model model, RedirectAttributes redirectAttributes) {
        try {
            userService.save(registrationDto);
            redirectAttributes.addFlashAttribute("successMessage", "Account created successfully!");
            return "redirect:/login?success";
        } catch (Error e) {
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/registration?error";
        }
    };
}
