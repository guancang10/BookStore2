package com.guancang10.BookStore.util.converter;

import com.guancang10.BookStore.payload.request.CreateBookRequest;
import com.guancang10.BookStore.model.Book;
import com.guancang10.BookStore.payload.response.GetBookResponse;
import com.guancang10.BookStore.payload.response.GetListBookResponse;

import java.util.ArrayList;
import java.util.List;

public class BookConverter {
    public static Book convertRequestToBook(CreateBookRequest bookRequest){
        Book result = new Book();
        result.setBookName(bookRequest.getBookName());
        result.setBookDescription(bookRequest.getBookDescription());
        result.setAuthor(bookRequest.getAuthor());
        result.setPrice(bookRequest.getPrice());
        result.setQty(bookRequest.getQty());
        result.setCategoryId(bookRequest.getCategoryId());

        return result;
    }

    public static GetBookResponse convertBookToResponse(Book book){
        GetBookResponse response = new GetBookResponse(book.getId(),book.getBookName(), book.getBookDescription(), book.getAuthor(),book.getCategoryId(),book.getPrice(),book.getQty());
        return response;
    }

    public static GetListBookResponse convertListBookToResponse(List<Book> books){
        List<GetBookResponse> listBook = new ArrayList<>();
        books.forEach(x -> listBook.add(convertBookToResponse(x)));
        GetListBookResponse listBookResponse = new GetListBookResponse(listBook);
        return listBookResponse;
    }
}
