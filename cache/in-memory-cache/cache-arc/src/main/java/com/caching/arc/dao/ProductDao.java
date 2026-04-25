package com.caching.arc.dao;

import org.springframework.stereotype.Service;

import com.caching.arc.entity.Product;

@Service
public class ProductDao {
    //simulate the product dao for 5 products with id, name and price
    public Product getProductById(Long id) {    
        return switch (id.intValue()) {
            case 1 -> new Product(1L, "Laptop", 10.0);
            case 2 -> new Product(2L, "Mouse", 20.0);
            case 3 -> new Product(3L, "Keyboard", 30.0);
            case 4 -> new Product(4L, "Monitor", 40.0);
            case 5 -> new Product(5L, "Headphones", 50.0);
            default -> null;
        };
    }
}
