package com.madthreed.polls_api.controller;


import com.madthreed.polls_api.exceptions.BadRequestException;
import com.madthreed.polls_api.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handle_NOT_FOUND(ResourceNotFoundException exception, HttpServletRequest request) {
        log.error("NOT_FOUND", exception);
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handle_BAD_REQUEST(BadRequestException exception, HttpServletRequest request) {
        log.error("BAD_REQUEST", exception);
        return new ResponseEntity<>("You gave an incorrect values", HttpStatus.BAD_REQUEST);
    }


//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<String> handle_INTERNAL_SERVER_ERROR(RuntimeException exception, HttpServletRequest request) {
//        log.error("INTERNAL_SERVER_ERROR", exception);
//        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}