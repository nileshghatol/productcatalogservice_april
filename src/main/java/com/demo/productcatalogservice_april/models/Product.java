package com.demo.productcatalogservice_april.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel{
    private String name;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;
}
