package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.Book;
import com.guancang10.BookStore.model.Category;
import com.guancang10.BookStore.repository.IBookRepository;
import com.guancang10.BookStore.repository.ICategoryRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Book save(Book book) {
        if(categoryRepository.existsById(book.getCategoryId())){
            bookRepository.save(book);
            return book;
        }else{
            throw new NoSuchElementException("Category with Id " + book.getCategoryId() + " not exists");
        }

    }

    @Override
    public Book getBook(int id) {
        if(bookRepository.existsById(id)){
            return bookRepository.findById(id).orElse(null);
        }else{
            throw new NoSuchElementException("Book with id " + id + " not exist");
        }
    }

    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(int id, Book book) {
        if(bookRepository.existsById(id)){
            if(categoryRepository.existsById(book.getCategoryId())){
                book.setId(id);
                bookRepository.save(book);
                return book;
            }else{
                throw new NoSuchElementException("Category with Id " + book.getCategoryId() + " not exists");
            }
        }else{
            throw new NoSuchElementException("Book with id " + id + " not exist");
        }
    }

    @Override
    public void deleteBook(int id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Book with id " + id + " not exist");
        }
    }

    @Override
    public Book addQty(int id, int qty) {
        Book book = getBook(id);
        book.setQty(book.getQty() + qty);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book subQty(int id, int qty) {
        Book book = getBook(id);
        if(book.getQty() < qty){
            throw new ValidationException("Can't subtract quantity more than current quantity");
        }

        book.setQty(book.getQty() - qty);
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getListBookByCategory(int categoryId) {
        List<Book> result = bookRepository.findAll().stream()
                .filter(book -> book.getCategoryId() == categoryId)
                .distinct()
                .toList();
        return result;
    }
}
