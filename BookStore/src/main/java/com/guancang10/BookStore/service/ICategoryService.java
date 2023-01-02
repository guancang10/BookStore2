package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.Category;

import java.util.List;

public interface ICategoryService {
    Category saveCategory(Category category);
    List<Category> getAll();
    Category getCategory(int categoryId);
    Boolean deleteCategory(int categoryId);
    Category updateCategory(int categoryId,String categoryName);
}
