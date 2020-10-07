package com.example.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PagesController {
    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(value ="/public")
    public String publicPage() {
        return "public";
    }

    @GetMapping(value ="/authenticated")
    public String authenticatedPage() {
        return "authenticated";
    }

//    @GetMapping(value ="/logout")
//    public String logoutPage() {
//        SecurityContextHolder.getContext().setAuthentication(null);
//        return "logout";
//    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
}
