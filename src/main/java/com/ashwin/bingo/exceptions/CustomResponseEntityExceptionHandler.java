package com.ashwin.bingo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <h1>CustomResponseEntityExceptionHandler</h1>
 * Used to handle custom exceptions
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public final ResponseEntity<Object> handleGameException(GameException ex, WebRequest webRequest)
    {
        GameExceptionResponse gameExceptionResponse = new GameExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(gameExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserException(UserException ex, WebRequest webRequest)
    {
        UserExceptionResponse userExceptionResponse = new UserExceptionResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(userExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
