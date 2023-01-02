package com.guancang10.BookStore.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public ErrorResponse(){
        this.timestamp = LocalDateTime.now();
    }
}
