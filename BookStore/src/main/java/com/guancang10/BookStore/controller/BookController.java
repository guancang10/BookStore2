package com.guancang10.BookStore.controller;


import com.guancang10.BookStore.payload.request.CreateBookRequest;
import com.guancang10.BookStore.model.Book;
import com.guancang10.BookStore.service.BookService;
import com.guancang10.BookStore.util.WebResposne;
import com.guancang10.BookStore.util.converter.BookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {


    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity saveBook(@RequestBody CreateBookRequest book){
        Book result = bookService.save(BookConverter.convertRequestToBook(book));
        return new WebResposne(HttpStatus.OK,BookConverter.convertBookToResponse(result)).buildResponse();
    }

    @GetMapping("/{book_id}")
    public ResponseEntity getBook(@PathVariable("book_id") int bookId){
        Book result = bookService.getBook(bookId);
        return new WebResposne(HttpStatus.OK,BookConverter.convertBookToResponse(result)).buildResponse();
    }

    @GetMapping()
    public ResponseEntity getAllBook(){
        List<Book> result = bookService.getListBook();
        return new WebResposne(HttpStatus.OK,BookConverter.convertListBookToResponse(result)).buildResponse();
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity getAllBookByCategory(@PathVariable("category_id") int categoryId){
        List<Book> result = bookService.getListBookByCategory(categoryId);
        return new WebResposne(HttpStatus.OK,BookConverter.convertListBookToResponse(result)).buildResponse();
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity deleteBook(@PathVariable("book_id") int bookId){
        bookService.deleteBook(bookId);
        return new WebResposne(HttpStatus.OK,"Success delete book").buildResponse();
    }

    @PutMapping("/quantity/add/{book_id}")
    public ResponseEntity addBookQty(@PathVariable("book_id") int bookId, @RequestBody Map<String,String> body){
        Book result = bookService.addQty(bookId,Integer.parseInt(body.get("qty")));
        return new WebResposne(HttpStatus.OK,result).buildResponse();
    }

    @PutMapping("/quantity/sub/{book_id}")
    public ResponseEntity subBookQty(@PathVariable("book_id") int bookId, @RequestBody Map<String,String> body){
        Book result = bookService.subQty(bookId,Integer.parseInt(body.get("qty")));
        return new WebResposne(HttpStatus.OK,result).buildResponse();
    }

    @PutMapping("/{book_id}")
    public ResponseEntity updateBook(@PathVariable("book_id") int bookId,@RequestBody CreateBookRequest book){
        Book result = bookService.updateBook(bookId,BookConverter.convertRequestToBook(book));
        return new WebResposne(HttpStatus.OK,result).buildResponse();
    }

}
