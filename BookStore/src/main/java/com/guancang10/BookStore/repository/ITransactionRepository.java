package com.guancang10.BookStore.repository;

import com.guancang10.BookStore.model.TrBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<TrBook,Integer> {
}
