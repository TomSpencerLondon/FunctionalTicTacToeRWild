package tictactoe;

public class Game {
  public GameState state() {
    return new GameState(Status.GAME_ON, Player.X);
  }
}
