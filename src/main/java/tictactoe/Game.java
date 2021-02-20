package tictactoe;

import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Status.GAME_ON;

public class Game {
  private final Status status;
  private final Player lastPlayer;

  public Game() {
    status = GAME_ON;
    lastPlayer = null;
  }

  public Game(Status status, Player lastPlayer) {
    this.status = status;
    this.lastPlayer = lastPlayer;
  }

  public GameState state() {
    return new GameState(status, nextPlayer());
  }

  public Game play() {
    return new Game(GAME_ON, nextPlayer());
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
