# Bingo-Game-Server
Spring boot applciation for Bingo game server

## Details about application

### Clone the Repository using the following command
```bash
git clone https://github.com/ashraghunath/Bingo-Game-Server.git
default port 8080
```
### Endpoint usages in Heroku
```bash
Base URL : https://enigmatic-stream-62184.herokuapp.com/
1) https://enigmatic-stream-62184.herokuapp.com/api/game/create -> returns game_id for game created 
2) https://enigmatic-stream-62184.herokuapp.com/api/game/{game_id}/ticket/{user_name}/generate -> generates 5*5 bingo ticket for user_name and returns ticket_id
3) https://enigmatic-stream-62184.herokuapp.com/api/game/{game_id}/ticket{ticket_id} -> returns HTML ticket for ticket_id in game with ID game_id.
4) https://enigmatic-stream-62184.herokuapp.com/api/game/{game_id}/number/random -> returns random number from 5*5 bingo ticket without duplicates.
5) https://enigmatic-stream-62184.herokuapp.com/api/game/{game_id}/numbers -> returns all numbers picked for game using 4).
5) https://enigmatic-stream-62184.herokuapp.com/api/game/{game_id}/stats -> returns statistics of game with ID game_id
 ```
