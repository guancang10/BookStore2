package com.guancang10.BookStore.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "trbook")
public class TrBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Min(value = 1,message = "HtrBookId not valid")
    @NotNull(message = "htrbook id cannot be null")
    @JsonProperty("htr_book_id")
    private int HtrBookId;

    @Min(value = 1,message = "BookId not valid")
    @NotNull(message = "Book Id cannot be null")
    @JsonProperty("book_id")
    private int BookId;


    @Min(value = 1,message = "Quantity must more then 0")
    @NotNull(message = "Quantity cannot be null")
    @JsonProperty("qty")
    private int Qty;

    public TrBook() {
    }
}
