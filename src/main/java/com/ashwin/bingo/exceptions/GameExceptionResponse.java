package com.ashwin.bingo.exceptions;

/**
 * <h1>GameExceptionResponse</h1>
 * Response management of GameException
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
public class GameExceptionResponse {

    private String gameException;

    public GameExceptionResponse(String gameException) {
        this.gameException = gameException;
    }

    public String getGameException() {
        return gameException;
    }

    public void setGameException(String gameException) {
        this.gameException = gameException;
    }
}
