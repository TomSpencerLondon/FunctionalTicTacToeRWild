package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Player.O;
import static tictactoe.Player.X;
import static tictactoe.Status.GAME_ON;


public class GameShould {

  @Test
  void wait_for_X_to_play_first() {
    Game game = new Game();
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }

  @Test
  void wait_for_O_to_play_after_X() {
    Game game = new Game();
    game = game.play();
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, O));
  }

  @Test
  void alternate_players() {
    Game game = new Game();
    game = game.play();
    game = game.play();
    assertThat(game.state()).isEqualTo(new GameState(GAME_ON, X));
  }
}
