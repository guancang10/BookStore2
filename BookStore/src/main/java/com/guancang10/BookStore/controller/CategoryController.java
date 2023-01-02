package com.guancang10.BookStore.controller;

import com.guancang10.BookStore.model.Category;
import com.guancang10.BookStore.payload.request.CreateCategoryRequest;
import com.guancang10.BookStore.service.CategoryService;
import com.guancang10.BookStore.service.ICategoryService;
import com.guancang10.BookStore.util.WebResposne;
import com.guancang10.BookStore.util.converter.CategoryConverter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private ICategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CreateCategoryRequest category){
        Category result = categoryService.saveCategory(CategoryConverter.convertRequestToCategory(category));
        return new WebResposne(HttpStatus.OK,CategoryConverter.convertCategoryToResponse(result)).buildResponse();
    }

    @GetMapping("/{category_id}")
    public ResponseEntity getCategory(@PathVariable("category_id") int id){
        Category result = categoryService.getCategory(id);
        return new WebResposne(HttpStatus.OK,CategoryConverter.convertCategoryToResponse(result)).buildResponse();
    }

    @GetMapping()
    public ResponseEntity getAllCategory(){
        List<Category> result = categoryService.getAll();
        return new WebResposne(HttpStatus.OK,CategoryConverter.convertListCategoryToResponse(result)).buildResponse();
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity deleteCategory(@PathVariable("category_id") int id){
        categoryService.deleteCategory(id);
        return new WebResposne(HttpStatus.OK,"Delete success").buildResponse();
    }

    @PutMapping("/{category_id}")
    public ResponseEntity updateCategory(@PathVariable("category_id") int id,CreateCategoryRequest request){
        Category result = categoryService.updateCategory(id,request.getCategoryName());
        return new WebResposne(HttpStatus.OK,CategoryConverter.convertCategoryToResponse(result)).buildResponse();
    }

}
