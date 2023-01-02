package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.Category;
import com.guancang10.BookStore.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CategoryService implements ICategoryService{


    private ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository repository){
        this.categoryRepository = repository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
       return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(int categoryId) {
        if(categoryRepository.existsById(categoryId)){
            return categoryRepository.findById(categoryId).orElse(null);
        }else{
            throw new NoSuchElementException("Category with Id " + categoryId + " not exists");
        }
    }

    @Override
    public Boolean deleteCategory(int categoryId) {
        if(categoryRepository.existsById(categoryId)){
            categoryRepository.deleteById(categoryId);
            return true;
        }else{
            throw new NoSuchElementException("Category with Id " + categoryId + " not exists");
        }
    }

    @Override
    public Category updateCategory(int categoryId, String category) {
        if(categoryRepository.existsById(categoryId)){
            Category newCategory = categoryRepository.findById(categoryId).get();
            newCategory.setCategoryName(category);
            categoryRepository.save(newCategory);
            return newCategory;
        }else{
            throw new NoSuchElementException("Category with Id " + categoryId + " not exists");
        }
    }
}
