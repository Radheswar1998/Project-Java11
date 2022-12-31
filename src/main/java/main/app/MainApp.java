package main.app;

import main.app.entity.Product;
import main.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);
    }
    @Override
    public void run(String... arg0) throws Exception {
        for(Product product : productRepository.findAll()) {
            System.out.println("Id: " + product.getId());
        }
    }
}
