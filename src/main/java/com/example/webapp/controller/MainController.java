package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Product> messages = productRepo.findAll();

        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String prodtype, @RequestParam String price, Map<String, Object> model) {
        Product product = new Product(text, prodtype, Long.valueOf(price));
        productRepo.save(product);
        Iterable<Product> messages = productRepo.findAll();

        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Product> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = productRepo.findByProdtype(filter);
        } else {
            messages = productRepo.findAll();
        }

        model.put("messages", messages);
        return "main";
    }

    @PostMapping("dell")
    public String dell(@RequestParam String dell, Map<String, Object> model) {
        if (dell != null && !dell.isEmpty()
                && productRepo.existsById(Long.valueOf(dell))) {
            productRepo.deleteById(Long.valueOf(dell));
        }
        Iterable<Product> messages = productRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}
