package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CategoryPutRequestDto;
import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    public CategoryEndpoint(CategoryMapper categoryMapper, CategoryService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCategoryDto> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        categoryService.save(categoryMapper.map(createCategoryDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<CategoryResponseDto> getAllCategories() {
        return categoryMapper.map(categoryService.getAllCategories());
    }

    @PutMapping()
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryPutRequestDto categoryPutRequestDto) {
        categoryService.save(categoryMapper.map(categoryPutRequestDto));
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}