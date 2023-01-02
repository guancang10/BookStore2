package com.guancang10.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "htrbook")
public class HtrBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

//    @NotBlank(message = "Username cannot be null")
//    @Size(min=8,max = 20,message = "Username must more then equal 8 and less then equal 20")
//    @JsonProperty("username")
//    private String Username;

    @NotNull(message = "Total price cannot be null")
    @JsonProperty("total_price")
    private double TotalPrice;

    @NotNull
    private LocalDateTime TransactionDate;

    @NotNull(message = "Status Id cannot be null")
    @Size(min=1,message = "Status Id not valid")
    @JsonProperty("status_id")
    private int StatusId;


    public HtrBook() {
    }
}
