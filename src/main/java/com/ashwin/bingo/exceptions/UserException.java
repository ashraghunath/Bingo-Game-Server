package com.ashwin.bingo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <h1>UserException</h1>
 * Exception related specifically to the user
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {
    public UserException(String message)
    {
        super(message);
    }
}
