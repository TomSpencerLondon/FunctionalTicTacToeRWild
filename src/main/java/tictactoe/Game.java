package tictactoe;

import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Status.*;

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
    if (board.hasWinningCombination(lastPlayer))
      this.status = lastPlayer == X ? X_HAS_WON : O_HAS_WON;
    else if (board.isFull())
      this.status = DRAW;
    else
      this.status = status;
  }

  public GameState state() {
    if (gameIsOver())
      return new GameState(status);
    else
      return new GameState(status, nextPlayer());
  }

  public Game play(Square square) {
    if (gameIsOver())
      return this;
    if (board.alreadyTaken(square))
      return new Game(Status.SQUARE_ALREADY_PLAYED, lastPlayer, board);
    else
      return new Game(GAME_ON, nextPlayer(), board.take(square, nextPlayer()));
  }

  private boolean gameIsOver() {
    return (status == DRAW || status == X_HAS_WON || status == O_HAS_WON);
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
