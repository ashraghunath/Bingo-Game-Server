package com.ashwin.bingo.domain;

import java.util.List;

/**
 * <h1>Statistics class</h1>
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
public class Statistics {

    List<Integer> numbersDrawn;
    Integer ticketsCreated;
    Integer usersCreated;

    public Statistics(List<Integer> numbersDrawn, Integer ticketsCreated, Integer usersCreated) {
        this.numbersDrawn = numbersDrawn;
        this.ticketsCreated = ticketsCreated;
        this.usersCreated = usersCreated;
    }

    public List<Integer> getNumbersDrawn() {
        return numbersDrawn;
    }

    public void setNumbersDrawn(List<Integer> numbersDrawn) {
        this.numbersDrawn = numbersDrawn;
    }

    public Integer getTicketsCreated() {
        return ticketsCreated;
    }

    public void setTicketsCreated(Integer ticketsCreated) {
        this.ticketsCreated = ticketsCreated;
    }

    public Integer getUsersCreated() {
        return usersCreated;
    }

    public void setUsersCreated(Integer usersCreated) {
        this.usersCreated = usersCreated;
    }
}
