package main.app.repositories;

import main.app.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product,Integer>{
}
