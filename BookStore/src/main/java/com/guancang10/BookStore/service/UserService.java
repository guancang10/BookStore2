package com.guancang10.BookStore.service;

import com.guancang10.BookStore.model.User;
import com.guancang10.BookStore.repository.IUserRepository;
import com.guancang10.BookStore.util.ValidatorHelper;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    private Validator validator = ValidatorHelper.getValidator();

    @Override
    public void register(User user) {
        Set<ConstraintViolation<User>> error = validator.validate(user);
        if(error.size() != 0){
            throw new ConstraintViolationException(error);
        }
        if(!userRepository.existsById(user.getUsername())){
            userRepository.save(user);
        }else{
            throw new ValidationException("Username already exists");
        }
    }

    @Override
    public User login(String username, String password) {
        if(userRepository.existsById(username)){
            User result = userRepository.findById(username).get();
            result.setPassword("");
            if(result.getPassword().equals(password)){
                return result;
            }else{
                throw new NoSuchElementException("Username or password is wrong");
            }
        }else{
            throw new NoSuchElementException("Username or password is wrong");
        }
    }

    @Override
    public User updateProfile(String username, User user) {
        if(userRepository.existsById(username)){
            User userDb = userRepository.findById(username).get();
            if(!user.getFirstName().equals("")){
                userDb.setFirstName(user.getFirstName());
            }
            if(!user.getLastName().equals(userDb.getLastName())){
                userDb.setLastName(user.getLastName());
            }
            if(!user.getDOB().equals(userDb.getDOB())){
                userDb.setDOB(user.getDOB());
            }
            userRepository.save(userDb);

            userDb.setPassword("");
            return userDb;
        }else{
            throw new NoSuchElementException("Username not exists");
        }
    }

    @Override
    public User getUser(String username) {
        if(userRepository.existsById(username)){
            User user = userRepository.findById(username).get();
            user.setPassword("");
            return user;
        }else{
            throw new NoSuchElementException("Username not exists");
        }
    }

    @Override
    public void updatePassword(String username, String newPassword, String oldPassword) {
        if(userRepository.existsById(username)){
            User user = userRepository.findById(username).get();
            if(user.getPassword().equals(oldPassword)){
                user.setPassword(newPassword);
                userRepository.save(user);
            }else{
                throw new ValidationException("Password is wrong");
            }
        }else{
            throw new NoSuchElementException("Username not exist");
        }
    }
}
