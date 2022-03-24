package com.petrol.fuelquote.controller;

import com.petrol.fuelquote.model.Quote;
import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.service.QuoteService;
import com.petrol.fuelquote.service.UserService;
import com.petrol.fuelquote.web.dto.QuoteRequestDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class QuoteController {

    QuoteService quoteService;
    UserService userService;

    public QuoteController(QuoteService quoteService, UserService userService) {
        super();
        this.quoteService = quoteService;
        this.userService = userService;
    }

    @ModelAttribute("quote")
    public QuoteRequestDto quoteAdditionDto(){
        return new QuoteRequestDto();
    }

    @GetMapping("request")
    public String showQuoteRequestForm(){
        return "request";
    }

    @PostMapping("request")
    public String requestQuote(@ModelAttribute("quote") QuoteRequestDto dto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        dto.setUser(userService.getUserByUsername(username));
        dto.setRequestDate(new Date());
        quoteService.save(dto);
        return "redirect:/request?success";
    }

    @GetMapping("requests")
    public String showQuoteRequestList(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<Quote> quoteList = quoteService.listUserQuotes(userService.getUserByUsername(username));
        model.addAttribute("quoteList", quoteList);
        return "requestHistory";
    }
}
