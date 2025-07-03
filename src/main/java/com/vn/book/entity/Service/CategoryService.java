package com.vn.book.entity.Service;

import com.vn.book.entity.entity.CategoryEntity;
import com.vn.book.entity.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }
}

