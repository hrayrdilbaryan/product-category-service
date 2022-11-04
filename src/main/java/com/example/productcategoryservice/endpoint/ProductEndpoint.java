package com.example.productcategoryservice.endpoint;


import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductEndpoint(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> byId = productService.getProductById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/creat")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto createProductDto) {
        productService.save(productMapper.map(createProductDto));
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/byCategory/{id}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}