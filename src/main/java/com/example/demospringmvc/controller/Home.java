package com.example.demospringmvc.controller;

import com.example.demospringmvc.model.Product;
import com.example.demospringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Home {
    @GetMapping("/home")
    public String toan(Model model) {
        model.addAttribute("sanPhams", ProductService.products);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        ProductService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        ProductService.products.add(product);
        return "redirect:/home";
    }

}
