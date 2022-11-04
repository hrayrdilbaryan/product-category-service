package com.example.productcategoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPutRequestDto {
    private int id;
    private String title;
    private double price;
    private int count;
    @JsonProperty(namespace = "categoryPutRequestDto")
    private CategoryPutRequestDto categoryPutRequestDto;
}
