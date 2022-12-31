package main.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    public Long getId() {
        return productId;
    }

    public void setId(Long productId) {
        this.productId = productId;
    }
    @Column(name = "product_name")
    private String productName;

    public String getName() {
        return productName;
    }

    public void setId(String productName) {
        this.productName = productName;
    }
    @Column(name = "price")
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setId(Double price) {
        this.price = price;
    }
    @Column(name = "discount")
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setId(int discount) {
        this.discount = discount;
    }

}
