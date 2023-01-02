package com.guancang10.BookStore.payload.response;


import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetListBookResponse {
    List<GetBookResponse> Books;
}
