package tictactoe;

import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Status.DRAW;
import static tictactoe.Status.GAME_ON;

public class Game {
  private final Status status;
  private final Player lastPlayer;
  private Board board;

  public Game() {
    status = GAME_ON;
    lastPlayer = null;
    board = new Board();
  }

  public Game(Status status, Player lastPlayer, Board board) {
    this.lastPlayer = lastPlayer;
    this.board = board;
    if (board.isFull())
      this.status = DRAW;
    else
      this.status = status;
  }

  public GameState state() {
    if (status == DRAW)
      return new GameState(status);
    else
      return new GameState(status, nextPlayer());
  }

  public Game play(Square square) {
    if (board.alreadyTaken(square))
      return new Game(Status.SQUARE_ALREADY_PLAYED, lastPlayer, board);
    else
      return new Game(GAME_ON, nextPlayer(), board.take(square));
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
