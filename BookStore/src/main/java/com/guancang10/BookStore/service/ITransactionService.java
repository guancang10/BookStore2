package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.HtrBook;
import com.guancang10.BookStore.model.TrBook;

import java.util.List;

public interface ITransactionService {
    HtrBook createTransaction(HtrBook transaction,List<TrBook> detailTransaction);
    HtrBook getTransactionHeaderUser(String username);
    HtrBook getTransactionDetail(int htrBookId);
    void updateTransactionStatus(int htrBookId,int statusId);
    HtrBook updateTransaction(int htrBookId,HtrBook transaction);
}
