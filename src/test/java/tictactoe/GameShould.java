package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Square.TOP_LEFT;
import static tictactoe.Square.TOP_MIDDLE;
import static tictactoe.Status.GAME_ON;
import static tictactoe.Status.SQUARE_ALREADY_PLAYED;


public class GameShould {

  @Test
  void wait_for_X_to_play_first() {
    Game game = new Game();
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }

  @Test
  void wait_for_O_to_play_after_X() {
    Game game = new Game();
    game = game.play(TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, O));
  }

  @Test
  void alternate_players() {
    Game game = new Game();
    game = game.play(TOP_LEFT);
    game = game.play(TOP_MIDDLE);
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }

  @Test
  void not_permit_square_to_be_played_twice() {
    Game game = play(TOP_LEFT, TOP_MIDDLE, TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(SQUARE_ALREADY_PLAYED, X));
  }

  private Game play(Square... squares) {
    return Arrays.stream(squares)
        .reduce(new Game(), Game::play, (a, b) -> null);
  }

}
