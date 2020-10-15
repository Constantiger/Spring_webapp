package com.spring.webapp.vers2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value="/panel")
    public String panelPage() {
        return "panel";
    }
}
