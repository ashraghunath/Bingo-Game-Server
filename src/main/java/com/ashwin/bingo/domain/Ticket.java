package com.ashwin.bingo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h1>Ticket class</h1>
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
@Entity
public class Ticket
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // to solve infinite recursion
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Lob
    private Integer ticket[][];
    private final int SIZE = 5;

    public Integer[][] getTicket() {
        return ticket;
    }

    public void setTicket(Integer[][] ticket) {
        this.ticket = ticket;
    }

    public Ticket()
    {
        List<Integer> range = IntStream.rangeClosed(1, 25)
                .boxed().collect(Collectors.toList());
        ticket = new Integer[SIZE][SIZE];
        Collections.shuffle(range);
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
                ticket[i][j]=range.remove(new Random().nextInt(range.size()));
        }
    }


}