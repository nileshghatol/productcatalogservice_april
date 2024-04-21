package com.demo.productcatalogservice_april.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String imageUrl;
    private FakeStoreRatingDTO rating;
}
