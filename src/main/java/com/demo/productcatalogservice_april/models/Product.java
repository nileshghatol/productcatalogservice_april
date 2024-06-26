package com.demo.productcatalogservice_april.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String name;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;
}
