package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category createCategory(Category category) throws Exception {
        Category category1 = findByName(category.getName());
        if (category1 != null) {
            throw new Exception("Category name is already taken!");
        }
        return categoryRepository.save(category);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory(Category category, Long id) throws Exception {
        Category category1 = getById(id);
        if(category1 == null){
            throw  new Exception("No such category found!");
        }
        category1.setName(category.getName());
        return categoryRepository.save(category1);
    }
    public Category deleteCategory(Long id) throws Exception{
        Category category = getById(id);
        if(category == null){
            throw  new Exception("Category not found");
        }
        categoryRepository.delete(category);
        return  category;
    }
}
