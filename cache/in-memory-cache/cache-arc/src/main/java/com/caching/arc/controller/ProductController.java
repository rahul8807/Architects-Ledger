package com.caching.arc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caching.arc.entity.Product;
import com.caching.arc.service.ProductService;

class ProductResponse {
    private Product product;
    private long responseTimeMs;

    public ProductResponse(Product product, long responseTimeMs) {
        this.product = product;
        this.responseTimeMs = responseTimeMs;
    }

    public Product getProduct() {
        return product;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }
}

@RestController
@RequestMapping("/products")
public class ProductController {

    //constructor injection of product service
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) throws InterruptedException {
        //add respone time in the response 
        long startTime = System.currentTimeMillis();
         Product product = productService.getProductById(id);
        long endTime = System.currentTimeMillis();
        long responseTimeMs = endTime - startTime;
        return new ProductResponse(product, responseTimeMs);
    }

}
