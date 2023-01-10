package main.app.repositories;

import main.app.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product,Long>{
    @Query(value = "SELECT * FROM product p WHERE p.product_name = :productName",nativeQuery = true)
    public List<Product> findByName(String productName);

    @Query(value = "SELECT * FROM product p WHERE p.product_name like %:productNameContains%",nativeQuery = true)
    public List<Product> findByNameContains(String productNameContains);
}
