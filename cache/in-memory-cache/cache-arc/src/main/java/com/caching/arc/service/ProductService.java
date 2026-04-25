package com.caching.arc.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.caching.arc.dao.ProductDao;
import com.caching.arc.entity.Product;

@Service
public class ProductService {

    //constructor injection of product dao
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Cacheable(value = "productCache", key = "#id")
    public Product getProductById(Long id)throws InterruptedException {
        Thread.sleep(10000); //simulate the delay of 10 seconds to fetch the product from database
        return productDao.getProductById(id);
    }
}
