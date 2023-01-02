package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.Book;

import java.util.List;

public interface IBookService {
    Book save(Book book);
    Book getBook(int id);
    List<Book> getListBook();

    List<Book> getListBookByCategory(int categoryId);
    Book updateBook(int id,Book book);
    void deleteBook(int id);
    Book addQty(int id,int qty);
    Book subQty(int id,int qty);
}
