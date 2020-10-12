package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
}
