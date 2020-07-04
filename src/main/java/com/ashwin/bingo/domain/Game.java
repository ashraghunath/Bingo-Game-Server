package com.ashwin.bingo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h1>Game class</h1>
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since   2020-07-04
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //Field based access
    @ElementCollection
    private List<Integer> numbersToBePicked;

    public List<Integer> getNumbersPicked() {
        return numbersPicked;
    }

    public void setNumbersPicked(List<Integer> numbersPicked) {
        this.numbersPicked = numbersPicked;
    }

    @ElementCollection
    private List<Integer> numbersPicked;

    public List<Integer> getNumbersToBePicked() {
        return numbersToBePicked;
    }

    public void setNumbersToBePicked(List<Integer> numbersToBePicked) {
        this.numbersToBePicked = numbersToBePicked;
    }


    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "game", orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_at;

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    public Game() {
        this.numbersToBePicked = IntStream.rangeClosed(1, 25)
                .boxed().collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}