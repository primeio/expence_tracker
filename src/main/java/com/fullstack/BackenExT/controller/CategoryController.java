package com.fullstack.BackenExT.controller;

import com.fullstack.BackenExT.dto.CategoryDto;
import com.fullstack.BackenExT.model.Category;
import com.fullstack.BackenExT.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {

        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {

        return categoryService.getCategory(id);
    }

    @PostMapping("/create")
    public Category createCategory(
            @RequestBody CategoryDto categoryDto) {

        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDto categoryDto) {

        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategory(id);

        return "Category deleted successfully";
    }
}