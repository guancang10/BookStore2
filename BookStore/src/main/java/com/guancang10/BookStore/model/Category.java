package com.guancang10.BookStore.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "Category name cannot be empty")
    @Size(min = 2,max = 50,message = "Category length must more then equal 1 and less then equal 50")
    @JsonAlias(value = "category_name")
    private String CategoryName;


    public Category(){

    }
}
