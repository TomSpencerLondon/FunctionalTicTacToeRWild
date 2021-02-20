package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameShould {

  @Test
  void wait_for_X_to_play_first() {
    Game game = new Game();
    assertThat(game.state()).isEqualTo(new GameState(Status.GAME_ON, Player.X));
  }

  @Test
  void wait_for_O_to_play_after_X() {
    Game game = new Game();
    game = game.play();
    assertThat(game.state()).isEqualTo(new GameState(Status.GAME_ON, Player.O));
  }
}
