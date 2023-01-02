package com.guancang10.BookStore.repository;

import com.guancang10.BookStore.model.HtrBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHTransactionRepository extends JpaRepository<HtrBook,Integer> {
}
