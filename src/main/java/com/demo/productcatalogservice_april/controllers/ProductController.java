package com.demo.productcatalogservice_april.controllers;

import com.demo.productcatalogservice_april.dtos.ProductDTO;
import com.demo.productcatalogservice_april.models.Product;
import com.demo.productcatalogservice_april.services.IProductService;
import com.demo.productcatalogservice_april.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        MultiValueMap<String, String > headers = new LinkedMultiValueMap<>();
        headers.add("called by", "Smart developer");
        try {
            if (productId < 1) {
                headers.add("called by", "Pagal developer");
                throw new IllegalArgumentException("Invalid Product ID");
            }
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product, headers, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
