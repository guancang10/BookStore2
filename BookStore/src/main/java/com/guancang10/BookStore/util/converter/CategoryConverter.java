package com.guancang10.BookStore.util.converter;

import com.guancang10.BookStore.model.Category;
import com.guancang10.BookStore.payload.request.CreateCategoryRequest;
import com.guancang10.BookStore.payload.response.category.GetCategoryResponse;
import com.guancang10.BookStore.payload.response.category.GetListCategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class CategoryConverter {
    public static Category convertRequestToCategory(CreateCategoryRequest request){
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        return category;
    }

    public static GetCategoryResponse convertCategoryToResponse(Category response){
        GetCategoryResponse categoryResponse = new GetCategoryResponse();
        categoryResponse.setId(response.getId());
        categoryResponse.setCategoryName(response.getCategoryName());
        return categoryResponse;
    }

    public static GetListCategoryResponse convertListCategoryToResponse(List<Category> response){
        GetListCategoryResponse listCategoryResponse = new GetListCategoryResponse();
        List<GetCategoryResponse> categoryResponses = new ArrayList<>();

        response.forEach(x ->{
            GetCategoryResponse categoryResponse = new GetCategoryResponse();
            categoryResponse.setId(x.getId());
            categoryResponse.setCategoryName(x.getCategoryName());
            categoryResponses.add(categoryResponse);
        });
        listCategoryResponse.setGetCategoryResponseList(categoryResponses);
        return listCategoryResponse;
    }
}
