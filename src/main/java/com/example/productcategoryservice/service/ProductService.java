package com.example.productcategoryservice.service;

import com.example.productcategoryservice.exception.ProductNotFoundException;
import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        if (id <= 0) {
            throw new ProductNotFoundException("Product does not exists this id - " + id);
        } else {
            Optional<Product> product = productRepository.findById(id);
            return product;
        }
    }

    public Product save(Product product) {
        if (product == null) {
            throw new NullPointerException("Product was passed null");
        }
        return productRepository.save(product);
    }

    public void deleteProductById(int id) {
        if (id <= 0) {
            throw new ProductNotFoundException("Product does not exists with this id `" + id);
        }
        productRepository.deleteById(id);
    }
}