package com.ashwin.bingo.web;

import com.ashwin.bingo.domain.Game;
import com.ashwin.bingo.domain.Statistics;
import com.ashwin.bingo.services.BingoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class BingoGameController {

    @Autowired
    BingoGameService gameService;

    @GetMapping("/create")
    public Long createNewGame()
    {
        Game game = new Game();
        Game gameReturned = gameService.saveOrUpdateGame(game);
        return gameReturned.getId();
    }

    @GetMapping("/{game_id}/number/random")
    public Integer generateRandomNumer(@PathVariable Long game_id)
    {
        return gameService.generateRandomNumber(game_id);
    }

    @GetMapping("/{game_id}/numbers")
    public List<Integer> fetchNumbersPicked(@PathVariable Long game_id)
    {
        return gameService.fetchNumbersPicked(game_id);
    }

    @GetMapping("/{game_id}/stats")
    public Statistics fetchGameStats(@PathVariable Long game_id)
    {
        return gameService.fetchStatistics(game_id);
    }

    @GetMapping("/{game_id}/ticket/{user_name}/generate")
    public Long generateTicket(@PathVariable Long game_id, @PathVariable String user_name)
    {
        return gameService.generateTicket(game_id,user_name);
    }

    @GetMapping("/{game_id}/ticket/{ticket_id}")
    public String fetchTicket(@PathVariable Long game_id, @PathVariable Long ticket_id)
    {
        return gameService.fetchTicket(game_id,ticket_id);

    }

}
