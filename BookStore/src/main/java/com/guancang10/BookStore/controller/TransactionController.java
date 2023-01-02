package com.guancang10.BookStore.controller;

import com.guancang10.BookStore.payload.request.TransactionRequest;
import com.guancang10.BookStore.model.HtrBook;
import com.guancang10.BookStore.service.TransactionService;
import com.guancang10.BookStore.util.WebResposne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Object> createTransaction(@RequestBody TransactionRequest transaction){
        HtrBook result = transactionService.createTransaction(transaction.getHtrBook(),transaction.getTrBooks());
        return new WebResposne(HttpStatus.OK,result).buildResponse();
    }
}
