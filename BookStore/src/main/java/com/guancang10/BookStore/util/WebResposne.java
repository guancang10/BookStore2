package com.guancang10.BookStore.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class WebResposne {
    private HttpStatus status;
    private Object result;

    public WebResposne(HttpStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    public ResponseEntity<Object> buildResponse(){
        return new ResponseEntity<Object>(this,status);
    }
}
