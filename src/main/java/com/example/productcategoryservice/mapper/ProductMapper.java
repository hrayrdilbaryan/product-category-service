package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;

import com.example.productcategoryservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {



    @Mapping(target = "category", source = "createCategoryDto")
    Product map(CreateProductDto createProductDto);

    @Mapping(target = "category", source = "categoryResponseDto")
    Product map(ProductResponseDto productResponseDto);

    @Mapping(target = "categoryResponseDto", source = "category")
    ProductResponseDto map(Product product);

    List<ProductResponseDto> map(List<Product> productList);
}
