package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Square.*;
import static tictactoe.Status.*;


public class GameShould {

  @Test
  void wait_for_X_to_play_first() {
    Game game = new Game();
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }

  @Test
  void wait_for_O_to_play_after_X() {
    Game game = play(TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, O));
  }

  @Test
  void alternate_players() {
    Game game = play(TOP_LEFT, TOP_MIDDLE);
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }

  @Test
  void not_permit_square_to_be_played_twice() {
    Game game = play(TOP_LEFT, TOP_MIDDLE, TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(SQUARE_ALREADY_PLAYED, X));
  }

  // X O X
  // X X O
  // O X O
  @Test
  void recognise_a_draw() {
    Game game = play(
        TOP_LEFT,
        TOP_MIDDLE,
        TOP_RIGHT,
        CENTRE_RIGHT,
        CENTRE_LEFT,
        BOTTOM_LEFT,
        CENTRE_MIDDLE,
        BOTTOM_RIGHT,
        BOTTOM_MIDDLE
    );
    assertThat(game.state()).isEqualTo(new GameState(DRAW));
  }

  private Game play(Square... squares) {
    return Arrays.stream(squares)
        .reduce(new Game(), Game::play, (a, b) -> null);
  }
}
