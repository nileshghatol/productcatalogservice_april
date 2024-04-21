package com.demo.productcatalogservice_april.services;

import com.demo.productcatalogservice_april.dtos.ProductDTO;
import com.demo.productcatalogservice_april.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();

    Product getProduct(Long productId);

    Product createProduct(ProductDTO productDTO);
}
