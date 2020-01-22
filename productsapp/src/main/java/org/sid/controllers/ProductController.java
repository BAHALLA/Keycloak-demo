package org.sid.controllers;

import org.sid.dao.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:index";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
}
