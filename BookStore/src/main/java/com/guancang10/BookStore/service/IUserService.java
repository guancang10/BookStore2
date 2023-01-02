package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.User;
import org.springframework.data.jpa.repository.Query;

public interface IUserService {
    void register(User user);

    User login(String username,String password);
    User updateProfile(String username,User user);
    User getUser(String username);
    void updatePassword(String username,String newPassword,String oldPassword);
}

