package com.fullstack.BackenExT.service;

import com.fullstack.BackenExT.dto.CategoryDto;
import com.fullstack.BackenExT.model.Category;
import com.fullstack.BackenExT.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category getCategory(Long id){
       return categoryRepository.findById(id).orElseThrow(()->
               new RuntimeException("Category not found with id :"+ id));
    }
    public Category addCategory(CategoryDto category){
        Category category1 = new Category();
        category1.setName(category.getName());
        return categoryRepository.save(category1);
    }
    public Category updateCategory(Long id, CategoryDto upCategory){

        Category existing = getCategory(id);
         existing.setName(upCategory.getName());
         return categoryRepository.save(existing);
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
