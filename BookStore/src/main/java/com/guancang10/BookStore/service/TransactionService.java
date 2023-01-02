package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.HtrBook;
import com.guancang10.BookStore.model.TrBook;
import com.guancang10.BookStore.repository.IHTransactionRepository;
import com.guancang10.BookStore.repository.ITransactionRepository;
import com.guancang10.BookStore.util.ValidatorHelper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class TransactionService implements ITransactionService{

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IHTransactionRepository htransctionRepository;

    private Validator validator = ValidatorHelper.getValidator();

    @Override
    public HtrBook createTransaction(HtrBook transaction, List<TrBook> detailTransaction) {
        Set<ConstraintViolation<HtrBook>> validatorHtrBook = validator.validate(transaction);
        if(validatorHtrBook.size() != 0){
            throw new ConstraintViolationException(validatorHtrBook);
        }
        transaction.setTransactionDate(LocalDateTime.now());
        htransctionRepository.save(transaction);
        return transaction;
    }

    @Override
    public HtrBook getTransactionHeaderUser(String username) {
        return null;
    }

    @Override
    public HtrBook getTransactionDetail(int htrBookId) {
        return null;
    }

    @Override
    public void updateTransactionStatus(int htrBookId, int statusId) {

    }

    @Override
    public HtrBook updateTransaction(int htrBookId, HtrBook transaction) {
        return null;
    }
}
