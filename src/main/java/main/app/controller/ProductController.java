package main.app.controller;

import main.app.entity.Product;
import main.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/allProduct")
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();

    }
}
