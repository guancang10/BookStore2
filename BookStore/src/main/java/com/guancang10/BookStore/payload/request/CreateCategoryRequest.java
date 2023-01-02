package com.guancang10.BookStore.payload.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCategoryRequest {
    @NotBlank(message = "Category name cannot be empty")
    @Size(min = 2,max = 50,message = "Category length must more then equal 1 and less then equal 50")
    @JsonAlias(value = "category_name")
    private String CategoryName;
}
