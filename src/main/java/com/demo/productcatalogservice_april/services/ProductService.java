package com.demo.productcatalogservice_april.services;

import com.demo.productcatalogservice_april.dtos.FakeStoreProductDTO;
import com.demo.productcatalogservice_april.dtos.ProductDTO;
import com.demo.productcatalogservice_april.models.Category;
import com.demo.productcatalogservice_april.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    RestTemplateBuilder restTemplateBuilder;

    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class).getBody();
        ArrayList<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO1 : fakeStoreProductDTO){
            products.add(getProduct(fakeStoreProductDTO1));
        }
        return products;
    }

    @Override
    public Product getProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDTO.class, productId).getBody();
        return getProduct(fakeStoreProductDTO);
    }

    public Product getProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setName(fakeStoreProductDTO.getTitle());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImageUrl());
        product.setDescription(fakeStoreProductDTO.getDescription());
        return product;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO= restTemplate.postForEntity("https://fakestoreapi.com/products", productDTO, FakeStoreProductDTO.class).getBody();
        return getProduct(fakeStoreProductDTO);
    }
}
