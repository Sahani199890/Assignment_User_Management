package com.example.Assignment_User_Management.exception_manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String,String>> exceptionHandling(MethodArgumentNotValidException ex){
            Map<String,String> map=new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error)->{
                String fieldname=error.getCode();
                String message=error.getDefaultMessage();
                map.put(fieldname,message);
            });
            return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
        }
    }
