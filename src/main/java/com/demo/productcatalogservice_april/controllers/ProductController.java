package com.demo.productcatalogservice_april.controllers;

import com.demo.productcatalogservice_april.dtos.ProductDTO;
import com.demo.productcatalogservice_april.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getProduct() {
        return null;
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setName("iPhone 15");
        product.setPrice(1000000D);
        return product;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productDTO;
    }
}
