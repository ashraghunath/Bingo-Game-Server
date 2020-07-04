package com.ashwin.bingo.services;

import com.ashwin.bingo.domain.Ticket;
import com.ashwin.bingo.domain.User;
import com.ashwin.bingo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

    /**
     * Used to save or update user
     * @param user user to be saved or updated
     * @return User user saved or updated in DB
     */
    public User saveUser(User user) {
        if (user.getId() == null) {
            Ticket ticket = new Ticket();
            user.setTicket(ticket);
            ticket.setUser(user);
            logger.info("New user saved with username : "+user.getUserName());
        }
        return userRepository.save(user);
    }

    /**
     * Used to fetch user by user_name
     * @param user_name user ot be fetched
     * @return User user fetched using user_name
     */
    public User fetchUserByUserName(String user_name) {
            return userRepository.findByUserName(user_name);
    }
}
