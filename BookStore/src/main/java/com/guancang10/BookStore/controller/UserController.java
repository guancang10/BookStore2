package com.guancang10.BookStore.controller;

import com.guancang10.BookStore.model.User;
import com.guancang10.BookStore.service.UserService;
import com.guancang10.BookStore.util.DateHelper;
import com.guancang10.BookStore.util.WebResposne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Map<String,String> body){
        User user = new User();
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));
        user.setFirstName(body.get("first_name"));
        user.setLastName(body.get("last_name"));
        user.setDOB(DateHelper.stringToDate(body.get("dob")));
        user.setRoleId(Integer.parseInt(body.get("role_id")));

        userService.register(user);
        return new WebResposne(HttpStatus.OK,"Success register user").buildResponse();
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Map<String,String> body){
        User user = userService.login(body.get("username"),body.get("password"));
        return new WebResposne(HttpStatus.OK,user).buildResponse();
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody Map<String,String> body){
        User user = new User();
        user.setUsername(body.get("username"));
        user.setFirstName(body.get("first_name"));
        user.setLastName(body.get("last_name"));
        user.setDOB(DateHelper.stringToDate(body.get("dob")));

        User result = userService.updateProfile(user.getUsername(),user);
        return new WebResposne(HttpStatus.OK,result).buildResponse();
    }

    @GetMapping("/{username}")
    public ResponseEntity getUser(@PathVariable("username") String username){
        User user = userService.getUser(username);
        return new WebResposne(HttpStatus.OK,user).buildResponse();
    }

    @PutMapping("/{username}")
    public ResponseEntity changePassword(@PathVariable("username") String username, @RequestBody Map<String,String> body){
        userService.updatePassword(username, body.get("new_password"),body.get("old_password"));
        return new WebResposne(HttpStatus.OK,"Success change password").buildResponse();
    }


}
