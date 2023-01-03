package main.app.controller;

import main.app.entity.Product;
import main.app.model.ProductInformation;
import main.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<ProductInformation> getAllProducts(){
        List<Product> productsInDB = (List<Product>) productRepository.findAll();
        List<ProductInformation> productsWithNameAndPrice = new ArrayList<>();
        for (Product product : productsInDB){
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProductName(product.getName());
            productInformation.setPrice(product.getPrice());
            productsWithNameAndPrice.add(productInformation);

        }
        return productsWithNameAndPrice;

    }
}
