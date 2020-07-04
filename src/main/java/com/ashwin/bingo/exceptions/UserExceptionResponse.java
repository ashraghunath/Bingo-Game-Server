package com.ashwin.bingo.exceptions;

/**
 * <h1>UserExceptionResponse</h1>
 * Response management of UserException
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
public class UserExceptionResponse {

    private String userException;

    public UserExceptionResponse(String userException) {
        this.userException = userException;
    }

    public String getUserException() {
        return userException;
    }

    public void setUserException(String userException) {
        this.userException = userException;
    }
}
