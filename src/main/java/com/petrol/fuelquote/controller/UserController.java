package com.petrol.fuelquote.controller;

import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.service.UserService;
import com.petrol.fuelquote.web.dto.UserRegisterationDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisterationDto userRegisterationDto(){
        return new UserRegisterationDto();
    }

    @GetMapping("registration")
    public String showRegisterationForm(){
        return "registration";
    }

    @PostMapping("registration")
    public String registerUser(@ModelAttribute("user")UserRegisterationDto dto){
        userService.save(dto);
        return "redirect:/registration?success";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser", currentUser);
        return "profilePage";
    }

}
