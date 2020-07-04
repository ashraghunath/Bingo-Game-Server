package com.ashwin.bingo.repository;

import com.ashwin.bingo.domain.Game;
import com.ashwin.bingo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

}
