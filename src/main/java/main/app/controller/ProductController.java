package main.app.controller;

import main.app.entity.Product;
import main.app.model.ProductInformation;
import main.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/allProduct")
    public List<ProductInformation> getAllProducts(){
        List<Product> productsInDB = (List<Product>) productRepository.findAll();
        List<ProductInformation> productsWithNameAndPrice = new ArrayList<>();
        for (Product product : productsInDB){
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProductName(product.getProductName());
            productInformation.setPrice(product.getPrice());
            productsWithNameAndPrice.add(productInformation);

        }
        return productsWithNameAndPrice;

    }

    @GetMapping("/allProductDetails")
    public List<Product> getAllProductsDetails(){
        List<Product> productsInDB = (List<Product>) productRepository.findAll();
        return productsInDB;

    }
    @GetMapping("/getByID/{id}")
    public Product getAllProductsByID(@PathVariable("id") Long id){
        Product product =  productRepository.findById(id).get();
        return product;

    }
    @GetMapping("/getByName/{productName}")
    public List<Product> getAllProductsByName(@PathVariable("productName") String productName){
        List<Product> productsByName =  productRepository.findByName(productName);
        return productsByName;

    }
    @GetMapping("/getByNameContains/{productNameContains}")
    public List<Product> getAllProductsLike(@PathVariable("productNameContains") String productNameContains){
        List<Product> productsByNameLike =  productRepository.findByNameContains(productNameContains);
        return productsByNameLike;

    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }
    @PostMapping("/createProductVendor")
    public Product createProductVendor(@RequestBody ProductInformation product) {
        Product savedProduct = new Product();
        savedProduct.setProductName(product.getProductName());
        savedProduct.setPrice(product.getPrice());
        productRepository.save(savedProduct);
        return savedProduct;
    }
    @PutMapping("/updateProductByID")
    public Product updateProductByID(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/deleteByID/{id}")
    public String deleteProductByID(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return ("Deleted");
    }



}
