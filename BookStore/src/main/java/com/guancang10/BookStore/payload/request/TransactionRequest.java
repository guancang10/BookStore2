package com.guancang10.BookStore.payload.request;

import com.guancang10.BookStore.model.HtrBook;
import com.guancang10.BookStore.model.TrBook;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TransactionRequest {
    private HtrBook htrBook;
    private List<TrBook> trBooks;
}
