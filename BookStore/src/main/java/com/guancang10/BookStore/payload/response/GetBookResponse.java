package com.guancang10.BookStore.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class GetBookResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Size(min=1,max=50,message = "Book name must more than equal 1 and less then equal 50 characters")
    @NotBlank(message = "Book name cannot be empty")
    @JsonProperty("book_name")
    private String BookName;

    @Size(min=50,max=255,message = "Book description must more than equal 50 and less then equal 255")
    @NotBlank(message = "Book description cannot be empty")
    @JsonProperty("book_description")
    private String BookDescription;

    @Size(min=5,max=50,message = "Author name must more then equal 5 and less then equal 50")
    @NotBlank(message = "Author name cannot be empty")
    @JsonProperty("author")
    private String Author;

    @NotNull(message = "Category id cannot be null")
    @JsonProperty("category_id")
    @Min(value = 1,message = "Category id not valid")
    private int CategoryId;


    @NotNull(message = "Price cannot be null")
    @Min(value = 0,message = "Price can't be negative")
    @JsonProperty("price")
    private double Price;

    @NotNull(message = "qty cannot be null")
    @Min(value = 0,message = "Quantity can't be negative")
    @JsonProperty("qty")
    private int Qty;
}
