package com.ashwin.bingo.services;

import com.ashwin.bingo.domain.Game;
import com.ashwin.bingo.domain.Statistics;
import com.ashwin.bingo.domain.Ticket;
import com.ashwin.bingo.domain.User;
import com.ashwin.bingo.exceptions.GameException;
import com.ashwin.bingo.exceptions.UserException;
import com.ashwin.bingo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class BingoGameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

    /**
     * Used to save or update game
     * @param game Game to be saved or updated
     * @return Game Game object saved
     */
    public Game saveOrUpdateGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * Used to find game by ID
     * @param gameId Id of game to be found
     * @return Game Game object found
     */
    public Game findGameById(Long gameId) {
        try {
            Optional<Game> game = gameRepository.findById(gameId);
            return game.get();
        } catch (Exception e) {
            throw new GameException("Game with ID " + gameId + " not found");
        }
    }

    /**
     * Used to generate ticket for a user of a game
     * @param game_id Id of game to be found
     * @param user_name user for which ticket has to be generated
     * @return long ticket ID
     */
    public long generateTicket(Long game_id, String user_name) {

        Game gameById = findGameById(game_id);
        if(userService.fetchUserByUserName(user_name)!=null)
        {
            throw new UserException("Ticket for "+user_name+" already exists");
        }
        else {
            List<User> users = gameById.getUsers();
            User user = new User();
            user.setGame(gameById);
            user.setUserName(user_name);
            User user1 = userService.saveUser(user);
            users.add(user1);
            saveOrUpdateGame(gameById);
            logger.info("Ticket with ID :"+user1.getTicket().getId()+" generated");
            return user1.getTicket().getId();
        }
    }

    /**
     * Used to generate random number in a game
     * @param game_id Id of game to be found
     * @return Integer random number generated
     */
    public Integer generateRandomNumber(Long game_id) {
        Game game = findGameById(game_id);
        List<Integer> numbersToBePicked = game.getNumbersToBePicked();
        if(numbersToBePicked.size()==0)
        {
            throw new GameException("All numbers picked");
        }
        else {
            Integer pickedNumber = numbersToBePicked.remove(new Random().nextInt(numbersToBePicked.size()));
            game.getNumbersPicked().add(pickedNumber);
            game.setNumbersToBePicked(numbersToBePicked);
            saveOrUpdateGame(game);
            logger.info("Random number generated  :" + pickedNumber);
            return pickedNumber;
        }
    }

    /**
     * Used to fetch the numbers picked in game till now
     * @param game_id Id of game to be found
     * @return List<Integer> the numbers picked till now
     */
    public List<Integer> fetchNumbersPicked(Long game_id) {
            Game game = findGameById(game_id);
        logger.info("Fetching numbers picked for game  :"+game_id);
            return game.getNumbersPicked();
    }

    /**
     * Used to fetch statistics of game
     * @param game_id Id of game to be found
     * @return Statistics statistics of game found
     */
    public Statistics fetchStatistics(Long game_id) {
            Game game = findGameById(game_id);
            Statistics statistics = new Statistics(game.getNumbersPicked(), game.getUsers().size(), game.getUsers().size());
            logger.info("Fetching statistic for game  :"+game_id);
            return statistics;
    }

    /**
     * Used to fetch ticket of a user
     * @param game_id Id of game to be found
     * @param ticket_id id of ticket to display
     * @return String ticket in html
     */
    public String fetchTicket(Long game_id, Long ticket_id) {
        Game game = findGameById(game_id);
        Ticket ticketToDisplay = null;
        for (User user : game.getUsers()) {
            if (user.getTicket().getId() == ticket_id) {
                ticketToDisplay = user.getTicket();
            }
        }
        logger.info("Fetching ticket with ID :"+ticketToDisplay.getId());
        String ticketInHtml = ticketService.formHtmlTable(ticketToDisplay);
        return ticketInHtml;
    }


}
