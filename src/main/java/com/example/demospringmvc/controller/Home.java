package com.example.demospringmvc.controller;

import com.example.demospringmvc.model.Product;
import com.example.demospringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    public String create(Product product, @RequestParam MultipartFile upImg) {
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/Module 4/demo_SpringMvc_C0922h1/src/main/webapp/WEB-INF/image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg("/image/"+ nameFile);
        ProductService.products.add(product);
        return "redirect:/home";
    }

}
