package com.demo.productcatalogservice_april.dtos;

import com.demo.productcatalogservice_april.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;
}
