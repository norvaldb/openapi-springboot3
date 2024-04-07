package com.demo.employees.exception;

import com.demo.employees.model.Error;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JDBCException.class)
    public ResponseEntity<Error> handleConstraintViolationException(ConstraintViolationException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new Error()
                .title(httpStatus.toString())
                .status(httpStatus.value())
                .detail(ex.getMessage()), httpStatus);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Error> handleNoSuchElementException(NoSuchElementException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new Error()
                .title(httpStatus.toString())
                .status(httpStatus.value())
                .detail(ex.getMessage()), httpStatus);
    }

}
