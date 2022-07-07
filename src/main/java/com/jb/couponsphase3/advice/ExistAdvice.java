package com.jb.couponsphase3.advice;

import com.jb.couponsphase3.exceptions.AlreadyExistsException;
import com.jb.couponsphase3.exceptions.NotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExistAdvice {
    @ExceptionHandler(value = {NotExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleNotExistException(Exception err) {
        return new ErrorDetails("Not Exist Error", err.getMessage());
    }

    @ExceptionHandler(value = {AlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleAlreadyExistsException(Exception err) {
        return new ErrorDetails("Already Exists Error", err.getMessage());
    }

}
