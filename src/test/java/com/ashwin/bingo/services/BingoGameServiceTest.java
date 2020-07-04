package com.ashwin.bingo.services;

import com.ashwin.bingo.domain.Game;
import com.ashwin.bingo.domain.Statistics;
import com.ashwin.bingo.domain.Ticket;
import com.ashwin.bingo.domain.User;
import com.ashwin.bingo.repository.GameRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BingoGameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private BingoGameService bingoGameService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveOrUpdateGame() {
        Game game = game();
        bingoGameService.saveOrUpdateGame(game);
        verify(gameRepository, times(1)).save(any(Game.class));
    }

    @Test
    public void findGameById() {
        Game game = game();
        Mockito.when(gameRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(game));
        Game gameById = bingoGameService.findGameById(game.getId());
        Assert.assertEquals(game.getId(), gameById.getId());
    }


    @Test
    public void fetchNumbersPicked() {
        Game game = game();
        Mockito.when(gameRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(game));
        List<Integer> integers = bingoGameService.fetchNumbersPicked(game.getId());
        Assert.assertEquals(integers.size(), 5);

    }

    @Test
    public void fetchStatistics() {
        Game game = game();
        Mockito.when(gameRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(game));
        Statistics statistics = bingoGameService.fetchStatistics(game.getId());
        Assert.assertEquals(statistics.getNumbersDrawn().size(), 5);
    }

    @Test
    public void fetchTicket() {
        Game game = game();
        Mockito.when(gameRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(game));
        Mockito.when(ticketService.formHtmlTable(any(Ticket.class))).thenReturn("<html>");
        String s = bingoGameService.fetchTicket(game.getId(), 1L);
        Assert.assertTrue(s,s.contains("<html>"));
    }


    private Game game()
    {
        Game game = new Game();
        game.setId(1L);
        List<Integer> arrayList = Arrays.asList(1,2,3,4,5);
        game.setNumbersPicked(arrayList);
        game.setNumbersToBePicked(IntStream.rangeClosed(1, 25)
                .boxed().collect(Collectors.toList()));
        User user = new User();
        user.setId(1);
        Ticket ticket = new Ticket();
        ticket.setId(1);
        user.setTicket(ticket);
        game.setUsers(Arrays.asList(user));
        return game;
    }
}