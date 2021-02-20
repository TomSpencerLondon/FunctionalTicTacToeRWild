package tictactoe;

import static tictactoe.Player.X;
import static tictactoe.Status.GAME_ON;

public class Game {
  private final Status status;
  private final Player nextUp;

  public Game() {
    status = GAME_ON;
    nextUp = X;
  }

  public Game(Status status, Player nextUp) {
    this.status = status;
    this.nextUp = nextUp;
  }

  public GameState state() {
    return new GameState(status, nextUp);
  }

  public Game play() {
    return new Game(GAME_ON, Player.O);
  }
}
