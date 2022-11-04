package com.example.productcategoryservice.service;

import com.example.productcategoryservice.exception.CategoryNotFoundException;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        if (category == null) {
            throw new NullPointerException("Category was passed null");
        }
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(int id) {
        if (id <= 0) {
            throw new CategoryNotFoundException("Category does not exists with this id" + id);
        }
        categoryRepository.deleteById(id);
    }


}
